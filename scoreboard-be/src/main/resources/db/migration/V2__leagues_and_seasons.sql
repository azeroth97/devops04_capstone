insert into leagues(name, alias, country)
values
    ('Premier League', 'PL', 'England')
  , ('Laliga', 'LL', 'Spain')
  , ('Bundesliga', 'BL', 'Germany')
  , ('Serie A', 'SA', 'Italy')
  , ('Ligue 1', 'L1', 'France')
;

insert into seasons(name, name2, alias)
values
    ('2021', '2021 - 2022', '2021/22')
  , ('2022', '2022 - 2023', '2022/23')
  , ('2023', '2023 - 2024', '2023/24')
  , ('2024', '2024 - 2025', '2024/25')
  , ('2025', '2025 - 2026', '2025/26')
  , ('2026', '2026 - 2027', '2026/27')
;


insert into season_leagues(season_id, league_id)
select distinct s.id as season_id, l.id as league_id
from seasons s cross join leagues l
order by season_id, league_id;
