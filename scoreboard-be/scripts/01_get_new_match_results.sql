update daily_raw_matches raw
set host_id = t.id
from teams t
where t.name = raw.host;

update daily_raw_matches raw
set guest_id = t.id
from teams t
where t.name = raw.guest;

insert into matches(
    league_id
  , season_id
  , match_week
  , match_date
  , match_date2
  , host_id
  , host_score
  , guest_id
  , guest_score
)
select
    league_id
  , season_id
  , match_week::int
  , match_date
  , match_date2
  , host_id
  , host_score
  , guest_id
  , guest_score
from daily_raw_matches
where (league_id, season_id, match_week::int, host_id, guest_id)
  not in (
    select league_id, season_id, match_week, host_id, guest_id
    from matches
  )
order by season_id, match_week::int, match_date2;


update matches m
set host_score = r.host_score
  , guest_score = r.guest_score
  , match_date = r.match_date
  , match_date2 = r.match_date2
  , status = upper(r.status)
from daily_raw_matches r
where m.league_id = r.league_id
  and m.season_id = r.season_id
  and m.match_week = r.match_week::int
  and m.host_id = r.host_id
  and m.guest_id = r.guest_id
;