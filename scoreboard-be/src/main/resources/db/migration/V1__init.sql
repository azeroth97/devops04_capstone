drop table if exists leagues;
create table leagues (
    id serial primary key
  , name text
  , alias text
  , country text
  , created_at timestamp default now()
  , updated_at timestamp default now()
);

drop table if exists seasons;
create table seasons (
    id serial primary key
  , name text
  , name2 text
  , alias text
  , created_at timestamp default now()
  , updated_at timestamp default now()
);

drop table if exists teams;
create table teams (
    id serial primary key
  , league_id int
  , name text
  , logo text
  , stadium text
  , created_at timestamp default now()
  , updated_at timestamp default now()
);

drop table if exists season_teams;
create table season_teams (
    id serial primary key
  , season_id int
  , team_id int
  , created_at timestamp default now()
  , updated_at timestamp default now()
);

drop table if exists season_leagues;
create table season_leagues (
    id serial primary key
  , season_id int
  , league_id int
  , created_at timestamp default now()
  , updated_at timestamp default now()
);


drop table if exists matches;
create table matches (
    id serial primary key
  , league_id int
  , season_id int
  , match_week int
  , match_date text
  , match_date2 date
  , status text
  , host_id int
  , host_score int
  , guest_id int
  , guest_score int
  , created_at timestamp default now()
  , updated_at timestamp default now()
);

drop table if exists ranks;
create table ranks (
    id serial primary key
  , league_id int
  , season_id int
  , position int
  , team_id int
  , played int
  , wins int
  , draws int
  , losses int
  , goals_for int
  , goals_against int
  , goals_diff int
  , points int
  , prev_position int
  , position_change int
  , form_results text
  , next_opponent int
  , created_at timestamp default now()
  , updated_at timestamp default now()
);

drop table if exists team_round_infos;
create table team_round_infos (
    id serial primary key
  , team_id int
  , league_id int
  , season_id int
  , match_id int
  , round int
  , is_host boolean
  , goals_for int
  , goals_against int
  , goals_diff int
  , result text
  , form_results text default '-----'
  , next_opponent int
  , created_at timestamp default now()
  , updated_at timestamp default now()
);
