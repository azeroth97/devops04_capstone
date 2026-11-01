alter table raw_epl_rankings add column if not exists league_id int;
alter table raw_laliga_rankings add column if not exists league_id int;
alter table raw_bundesliga_rankings add column if not exists league_id int;
alter table raw_seriea_rankings add column if not exists league_id int;
alter table raw_ligue1_rankings add column if not exists league_id int;

update raw_epl_rankings set league_id = 1;
update raw_laliga_rankings set league_id = 2;
update raw_bundesliga_rankings set league_id = 3;
update raw_seriea_rankings set league_id = 4;
update raw_ligue1_rankings set league_id = 5;

drop table if exists raw_rankings;
select * into raw_rankings
from raw_epl_rankings
  union select * from raw_laliga_rankings
  union select * from raw_bundesliga_rankings
  union select * from raw_seriea_rankings
  union select * from raw_ligue1_rankings
;

alter table raw_rankings
    add column if not exists season_id int
  , add column if not exists team_id int
;

update raw_rankings set season_id = 1 where season = '2021';
update raw_rankings set season_id = 2 where season = '2022';
update raw_rankings set season_id = 3 where season = '2023';
update raw_rankings set season_id = 4 where season = '2024';
update raw_rankings set season_id = 5 where season = '2025';
