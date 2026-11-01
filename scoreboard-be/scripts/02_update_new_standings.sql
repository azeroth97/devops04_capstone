truncate team_round_infos;
insert into team_round_infos(
    team_id, league_id, season_id, match_id, round, is_host
  , goals_for, goals_against, goals_diff
)
select distinct
    host_id as team_id, league_id, season_id, id, match_week, true
  , host_score, guest_score, (host_score - guest_score)
from matches
where host_score is not null and status = 'FINISHED'
  and season_id in (select max(id) from seasons)
union
select distinct
    guest_id as team_id, league_id, season_id, id, match_week, false
  , guest_score, host_score, (guest_score - host_score)
from matches
where guest_score is not null and status = 'FINISHED'
  and season_id in (select max(id) from seasons)
order by league_id, season_id, match_week, team_id;


----==== result
update team_round_infos
set result =
  case
    when goals_diff > 0 then 'W'
    when goals_diff < 0 then 'L'
    when goals_diff = 0 then 'D'
    else ''
  end
-- where coalesce(result, '') = ''
;

----==== next_opponent
update team_round_infos ri
set next_opponent = 
  case
    when ri.team_id = m.host_id
    then m.guest_id else m.host_id
  end
from matches m
where m.league_id = ri.league_id
  and m.season_id = ri.season_id
  and m.match_week = (ri.round + 1)
  and (ri.team_id = m.host_id or ri.team_id = m.guest_id)
  and ri.next_opponent is null;
;

----==== form_results
update team_round_infos ri
set form_results = (
  select lpad(string_agg(result, '' order by round), 5, '-')
  from (
    select result, round
    from team_round_infos ri2
    where ri2.team_id   = ri.team_id
      and ri2.league_id = ri.league_id
      and ri2.season_id = ri.season_id
      and ri2.round <= ri.round
      and coalesce(ri2.result, '') <> ''
      and ri2.season_id = (select max(id) from seasons)
    order by round desc limit 5
  ) last5
)
where round <> 1
  and coalesce(result, '') <> ''
  and coalesce(form_results, '') <> ''
  and season_id = (select max(id) from seasons)
;


----==== recalculate positions
-- recalculate stats from matches
update ranks r
set played = tmp.played
  , wins = tmp.wins
  , draws = tmp.draws
  , losses = tmp.losses
  , goals_for = tmp.goals_for
  , goals_against = tmp.goals_against
  , goals_diff = tmp.goals_for - tmp.goals_against
  , points = tmp.wins*3 + tmp.draws
from (
  select
      team_id
    , league_id
    , season_id
    , count(1) as played
    , count(1) filter (where result = 'W') as wins
    , count(1) filter (where result = 'D') as draws
    , count(1) filter (where result = 'L') as losses
    , sum(goals_for) as goals_for
    , sum(goals_against) as goals_against
  from team_round_infos
  where coalesce(result, '') <> ''
    and season_id = (select max(id) from seasons)
  group by team_id, league_id, season_id
) tmp
where r.team_id   = tmp.team_id
  and r.league_id = tmp.league_id
  and r.season_id = tmp.season_id
;

-- recalculate positions
update ranks
set prev_position = position
where season_id = (select max(id) from seasons);

update ranks r
set position = tmp.new_position
from (
  select id, row_number() over (
    partition by league_id, season_id
    order by points desc, goals_diff desc, goals_for desc, wins desc
  ) as new_position
  from ranks
) tmp
where r.id = tmp.id
  and r.season_id = (select max(id) from seasons);
;

update ranks
set position_change = prev_position - position 
where season_id = (select max(id) from seasons);

update ranks r
set form_results = tmp.form_results
  , next_opponent = tmp.next_opponent
from (
  select distinct on (team_id)
      team_id
    , league_id
    , form_results
    , next_opponent
  from team_round_infos
  order by team_id, season_id desc, round desc
) tmp
where tmp.team_id = r.team_id
  and tmp.league_id = r.league_id
  and r.season_id = (select max(id) from seasons);
;

