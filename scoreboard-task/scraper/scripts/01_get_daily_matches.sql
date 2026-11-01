alter table daily_epl_matches add column if not exists league_id int;
alter table daily_laliga_matches add column if not exists league_id int;
alter table daily_bundesliga_matches add column if not exists league_id int;
alter table daily_seriea_matches add column if not exists league_id int;
alter table daily_ligue1_matches add column if not exists league_id int;

update daily_epl_matches set league_id = 1;
update daily_laliga_matches set league_id = 2;
update daily_bundesliga_matches set league_id = 3;
update daily_seriea_matches set league_id = 4;
update daily_ligue1_matches set league_id = 5;

drop table if exists daily_raw_matches;
select * into daily_raw_matches
from daily_epl_matches
  union select * from daily_laliga_matches
  union select * from daily_bundesliga_matches
  union select * from daily_seriea_matches
  union select * from daily_ligue1_matches
;

alter table daily_raw_matches
    add column host text
  , add column host_id int
  , add column host_score int
  , add column guest text
  , add column guest_id int
  , add column guest_score int
  , add column season_id int
;

update daily_raw_matches set host = host_team;
update daily_raw_matches set guest = guest_team;


----====
  -- premier-league
  update daily_raw_matches set host = 'Brighton & Hove Albion' where host = 'Brighton';
  update daily_raw_matches set host = 'Leeds United' where host = 'Leeds';
  update daily_raw_matches set host = 'Leicester City' where host = 'Leicester';
  update daily_raw_matches set host = 'Manchester City' where host = 'M. City';
  update daily_raw_matches set host = 'Manchester United' where host = 'M. United';
  update daily_raw_matches set host = 'Newcastle United' where host = 'Newcastle';
  update daily_raw_matches set host = 'Sheffield United' where host = 'Sheffield Utd';
  update daily_raw_matches set host = 'Tottenham Hotspur' where host = 'Tottenham';
  update daily_raw_matches set host = 'West Ham United' where host = 'West Ham';
  update daily_raw_matches set host = 'Wolverhampton Wanderers' where host = 'Wolves';
  update daily_raw_matches set guest = 'Brighton & Hove Albion' where guest = 'Brighton';
  update daily_raw_matches set guest = 'Leeds United' where guest = 'Leeds';
  update daily_raw_matches set guest = 'Leicester City' where guest = 'Leicester';
  update daily_raw_matches set guest = 'Manchester City' where guest = 'M. City';
  update daily_raw_matches set guest = 'Manchester United' where guest = 'M. United';
  update daily_raw_matches set guest = 'Newcastle United' where guest = 'Newcastle';
  update daily_raw_matches set guest = 'Sheffield United' where guest = 'Sheffield Utd';
  update daily_raw_matches set guest = 'Tottenham Hotspur' where guest = 'Tottenham';
  update daily_raw_matches set guest = 'West Ham United' where guest = 'West Ham';
  update daily_raw_matches set guest = 'Wolverhampton Wanderers' where guest = 'Wolves';

  -- laliga
  update daily_raw_matches set host = 'Deportivo Alavés' where host = 'Alavés';
  update daily_raw_matches set host = 'RC Deportivo' where host = 'Deportivo';
  update daily_raw_matches set host = 'UD Almería' where host = 'Almería';
  update daily_raw_matches set host = 'Athletic Club' where host = 'Athletic';
  update daily_raw_matches set host = 'Atlético Madrid' where host = 'Atlético';
  update daily_raw_matches set host = 'FC Barcelona' where host = 'Barcelona';
  update daily_raw_matches set host = 'Real Betis' where host = 'Betis';
  update daily_raw_matches set host = 'Cádiz CF' where host = 'Cádiz';
  update daily_raw_matches set host = 'RC Celta' where host = 'Celta';
  update daily_raw_matches set host = 'Elche CF' where host = 'Elche';
  update daily_raw_matches set host = 'RCD Espanyol' where host = 'Espanyol';
  update daily_raw_matches set host = 'Getafe CF' where host = 'Getafe';
  update daily_raw_matches set host = 'Girona FC' where host = 'Girona';
  update daily_raw_matches set host = 'Granada CF' where host = 'Granada';
  update daily_raw_matches set host = 'UD Las Palmas' where host = 'Las Palmas';
  update daily_raw_matches set host = 'CD Leganés' where host = 'Leganés';
  update daily_raw_matches set host = 'Levante UD' where host = 'Levante';
  update daily_raw_matches set host = 'RCD Mallorca' where host = 'Mallorca';
  update daily_raw_matches set host = 'CA Osasuna' where host = 'Osasuna';
  update daily_raw_matches set host = 'Real Oviedo' where host = 'Oviedo';
  update daily_raw_matches set host = 'Rayo Vallecano' where host = 'Rayo';
  update daily_raw_matches set host = 'Real Sociedad' where host = 'R. Sociedad';
  update daily_raw_matches set host = 'Sevilla FC' where host = 'Sevilla';
  update daily_raw_matches set host = 'Valencia CF' where host = 'Valencia';
  update daily_raw_matches set host = 'Villarreal CF' where host = 'Villarreal';
  update daily_raw_matches set guest = 'Deportivo Alavés' where guest = 'Alavés';
  update daily_raw_matches set guest = 'RC Deportivo' where guest = 'Deportivo';
  update daily_raw_matches set guest = 'UD Almería' where guest = 'Almería';
  update daily_raw_matches set guest = 'Athletic Club' where guest = 'Athletic';
  update daily_raw_matches set guest = 'Atlético Madrid' where guest = 'Atlético';
  update daily_raw_matches set guest = 'FC Barcelona' where guest = 'Barcelona';
  update daily_raw_matches set guest = 'Real Betis' where guest = 'Betis';
  update daily_raw_matches set guest = 'Cádiz CF' where guest = 'Cádiz';
  update daily_raw_matches set guest = 'RC Celta' where guest = 'Celta';
  update daily_raw_matches set guest = 'Elche CF' where guest = 'Elche';
  update daily_raw_matches set guest = 'RCD Espanyol' where guest = 'Espanyol';
  update daily_raw_matches set guest = 'Getafe CF' where guest = 'Getafe';
  update daily_raw_matches set guest = 'Girona FC' where guest = 'Girona';
  update daily_raw_matches set guest = 'Granada CF' where guest = 'Granada';
  update daily_raw_matches set guest = 'UD Las Palmas' where guest = 'Las Palmas';
  update daily_raw_matches set guest = 'CD Leganés' where guest = 'Leganés';
  update daily_raw_matches set guest = 'Levante UD' where guest = 'Levante';
  update daily_raw_matches set guest = 'RCD Mallorca' where guest = 'Mallorca';
  update daily_raw_matches set guest = 'CA Osasuna' where guest = 'Osasuna';
  update daily_raw_matches set guest = 'Real Oviedo' where guest = 'Oviedo';
  update daily_raw_matches set guest = 'Rayo Vallecano' where guest = 'Rayo';
  update daily_raw_matches set guest = 'Real Sociedad' where guest = 'R. Sociedad';
  update daily_raw_matches set guest = 'Sevilla FC' where guest = 'Sevilla';
  update daily_raw_matches set guest = 'Valencia CF' where guest = 'Valencia';
  update daily_raw_matches set guest = 'Villarreal CF' where guest = 'Villarreal';

  -- bundesliga
  update daily_raw_matches set host = '1. FC Heidenheim' where host = '1. FC Heidenheim 1846';
  update daily_raw_matches set host = 'Arminia Bielefeld' where host = 'Arminia B.';
  update daily_raw_matches set host = 'FC Augsburg' where host = 'Augsburgo';
  update daily_raw_matches set host = 'FC Bayern Munich' where host = 'Bayern';
  update daily_raw_matches set host = 'Borussia Dortmund' where host = 'B. Dortmund';
  update daily_raw_matches set host = 'Borussia M’gladbach' where host = 'B. MGladbach';
  update daily_raw_matches set host = 'VfL Bochum' where host = 'Bochum';
  update daily_raw_matches set host = '1. FC Köln' where host = 'Colonia';
  update daily_raw_matches set host = 'SV Darmstadt 98' where host = 'Darmstadt 98';
  update daily_raw_matches set host = 'Eintracht Frankfurt' where host = 'Eintracht Fr.';
  update daily_raw_matches set host = 'SC Freiburg' where host = 'Friburgo';
  update daily_raw_matches set host = 'SpVgg Greuther Fürth' where host = 'Greuther Fürth';
  update daily_raw_matches set host = 'Hamburger SV' where host = 'Hamburgo';
  update daily_raw_matches set host = 'Hertha Berlin' where host = 'Hertha';
  update daily_raw_matches set host = 'TSG 1899 Hoffenheim' where host = 'Hoffenheim';
  update daily_raw_matches set host = 'Bayer 04 Leverkusen' where host = 'Leverkusen';
  update daily_raw_matches set host = '1. FSV Mainz 05' where host = 'Mainz 05';
  update daily_raw_matches set host = 'FC Schalke 04' where host = 'Schalke 04';
  update daily_raw_matches set host = 'FC St. Pauli' where host = 'St. Pauli';
  update daily_raw_matches set host = 'VfB Stuttgart' where host = 'Stuttgart';
  update daily_raw_matches set host = '1. FC Union Berlin' where host = 'Unión Berlín';
  update daily_raw_matches set host = 'Werder Bremen' where host = 'W. Bremen';
  update daily_raw_matches set host = 'VfL Wolfsburg' where host = 'Wolfsburgo';
  update daily_raw_matches set guest = '1. FC Heidenheim' where guest = '1. FC Heidenheim 1846';
  update daily_raw_matches set guest = 'Arminia Bielefeld' where guest = 'Arminia B.';
  update daily_raw_matches set guest = 'FC Augsburg' where guest = 'Augsburgo';
  update daily_raw_matches set guest = 'FC Bayern Munich' where guest = 'Bayern';
  update daily_raw_matches set guest = 'Borussia Dortmund' where guest = 'B. Dortmund';
  update daily_raw_matches set guest = 'Borussia M’gladbach' where guest = 'B. MGladbach';
  update daily_raw_matches set guest = 'VfL Bochum' where guest = 'Bochum';
  update daily_raw_matches set guest = '1. FC Köln' where guest = 'Colonia';
  update daily_raw_matches set guest = 'SV Darmstadt 98' where guest = 'Darmstadt 98';
  update daily_raw_matches set guest = 'Eintracht Frankfurt' where guest = 'Eintracht Fr.';
  update daily_raw_matches set guest = 'SC Freiburg' where guest = 'Friburgo';
  update daily_raw_matches set guest = 'SpVgg Greuther Fürth' where guest = 'Greuther Fürth';
  update daily_raw_matches set guest = 'Hamburger SV' where guest = 'Hamburgo';
  update daily_raw_matches set guest = 'Hertha Berlin' where guest = 'Hertha';
  update daily_raw_matches set guest = 'TSG 1899 Hoffenheim' where guest = 'Hoffenheim';
  update daily_raw_matches set guest = 'Bayer 04 Leverkusen' where guest = 'Leverkusen';
  update daily_raw_matches set guest = '1. FSV Mainz 05' where guest = 'Mainz 05';
  update daily_raw_matches set guest = 'FC Schalke 04' where guest = 'Schalke 04';
  update daily_raw_matches set guest = 'FC St. Pauli' where guest = 'St. Pauli';
  update daily_raw_matches set guest = 'VfB Stuttgart' where guest = 'Stuttgart';
  update daily_raw_matches set guest = '1. FC Union Berlin' where guest = 'Unión Berlín';
  update daily_raw_matches set guest = 'Werder Bremen' where guest = 'W. Bremen';
  update daily_raw_matches set guest = 'VfL Wolfsburg' where guest = 'Wolfsburgo';

  -- serie-a
  update daily_raw_matches set host = 'Bologna' where host = 'Bolonia';
  update daily_raw_matches set host = 'Como' where host = 'Como 1907';
  update daily_raw_matches set host = 'Internazionale' where host = 'Inter';
  update daily_raw_matches set host = 'SS Lazio' where host = 'Lazio';
  update daily_raw_matches set host = 'AC Milan' where host = 'Milan';
  update daily_raw_matches set host = 'Napoli' where host = 'Nápoles';
  update daily_raw_matches set host = 'AS Roma' where host = 'Roma';
  update daily_raw_matches set host = 'Hellas Verona' where host = 'Verona';
  update daily_raw_matches set guest = 'Bologna' where guest = 'Bolonia';
  update daily_raw_matches set guest = 'Como' where guest = 'Como 1907';
  update daily_raw_matches set guest = 'Internazionale' where guest = 'Inter';
  update daily_raw_matches set guest = 'SS Lazio' where guest = 'Lazio';
  update daily_raw_matches set guest = 'AC Milan' where guest = 'Milan';
  update daily_raw_matches set guest = 'Napoli' where guest = 'Nápoles';
  update daily_raw_matches set guest = 'AS Roma' where guest = 'Roma';
  update daily_raw_matches set guest = 'Hellas Verona' where guest = 'Verona';

  -- ligue-1
  update daily_raw_matches set host = 'Angers SCO' where host = 'Angers';
  update daily_raw_matches set host = 'AJ Auxerre' where host = 'Auxerre';
  update daily_raw_matches set host = 'Stade Brestois' where host = 'Brest';
  update daily_raw_matches set host = 'Clermont Foot' where host = 'Clermont';
  update daily_raw_matches set host = 'RC Strasbourg Alsace' where host = 'Estrasburgo';
  update daily_raw_matches set host = 'AC Ajaccio' where host = 'Gazélec Ajaccio';
  update daily_raw_matches set host = 'Girondins de Bordeaux' where host = 'Girondins';
  update daily_raw_matches set host = 'Le Havre AC' where host = 'Le Havre';
  update daily_raw_matches set host = 'RC Lens' where host = 'Lens';
  update daily_raw_matches set host = 'Lille OSC' where host = 'Lille';
  update daily_raw_matches set host = 'FC Lorient' where host = 'Lorient';
  update daily_raw_matches set host = 'Olympique Lyonnais' where host = 'Lyon';
  update daily_raw_matches set host = 'Olympique de Marseille' where host = 'Marsella';
  update daily_raw_matches set host = 'FC Metz' where host = 'Metz';
  update daily_raw_matches set host = 'AS Monaco' where host = 'Monaco';
  update daily_raw_matches set host = 'Montpellier HSC' where host = 'Montpellier';
  update daily_raw_matches set host = 'FC Nantes' where host = 'Nantes';
  update daily_raw_matches set host = 'OGC Nice' where host = 'Niza';
  update daily_raw_matches set host = 'Paris FC' where host = 'París FC';
  update daily_raw_matches set host = 'Paris Saint-Germain' where host = 'PSG';
  update daily_raw_matches set host = 'Stade Rennais' where host = 'Rennes';
  update daily_raw_matches set host = 'AS Saint-Etienne' where host = 'Saint-Etienne';
  update daily_raw_matches set host = 'Toulouse FC' where host = 'Toulouse';
  update daily_raw_matches set host = 'ESTAC Troyes' where host = 'Troyes';
  update daily_raw_matches set guest = 'Angers SCO' where guest = 'Angers';
  update daily_raw_matches set guest = 'AJ Auxerre' where guest = 'Auxerre';
  update daily_raw_matches set guest = 'Stade Brestois' where guest = 'Brest';
  update daily_raw_matches set guest = 'Clermont Foot' where guest = 'Clermont';
  update daily_raw_matches set guest = 'RC Strasbourg Alsace' where guest = 'Estrasburgo';
  update daily_raw_matches set guest = 'AC Ajaccio' where guest = 'Gazélec Ajaccio';
  update daily_raw_matches set guest = 'Girondins de Bordeaux' where guest = 'Girondins';
  update daily_raw_matches set guest = 'Le Havre AC' where guest = 'Le Havre';
  update daily_raw_matches set guest = 'RC Lens' where guest = 'Lens';
  update daily_raw_matches set guest = 'Lille OSC' where guest = 'Lille';
  update daily_raw_matches set guest = 'FC Lorient' where guest = 'Lorient';
  update daily_raw_matches set guest = 'Olympique Lyonnais' where guest = 'Lyon';
  update daily_raw_matches set guest = 'Olympique de Marseille' where guest = 'Marsella';
  update daily_raw_matches set guest = 'FC Metz' where guest = 'Metz';
  update daily_raw_matches set guest = 'AS Monaco' where guest = 'Monaco';
  update daily_raw_matches set guest = 'Montpellier HSC' where guest = 'Montpellier';
  update daily_raw_matches set guest = 'FC Nantes' where guest = 'Nantes';
  update daily_raw_matches set guest = 'OGC Nice' where guest = 'Niza';
  update daily_raw_matches set guest = 'Paris FC' where guest = 'París FC';
  update daily_raw_matches set guest = 'Paris Saint-Germain' where guest = 'PSG';
  update daily_raw_matches set guest = 'Stade Rennais' where guest = 'Rennes';
  update daily_raw_matches set guest = 'AS Saint-Etienne' where guest = 'Saint-Etienne';
  update daily_raw_matches set guest = 'Toulouse FC' where guest = 'Toulouse';
  update daily_raw_matches set guest = 'ESTAC Troyes' where guest = 'Troyes';
----****

update daily_raw_matches set result = replace(result, ' ', '');
update daily_raw_matches set host_score = (string_to_array(result, '-'))[1]::int where result not ilike '%z%';
update daily_raw_matches set guest_score = (string_to_array(result, '-'))[2]::int where result not ilike '%z%';

alter table daily_raw_matches add column season2 text;
alter table daily_raw_matches add column match_date2 date;

update daily_raw_matches set season_id = 1, season2 = '2021/2022' where match_season = '2021';
update daily_raw_matches set season_id = 2, season2 = '2022/2023' where match_season = '2022';
update daily_raw_matches set season_id = 3, season2 = '2023/2024' where match_season = '2023';
update daily_raw_matches set season_id = 4, season2 = '2024/2025' where match_season = '2024';
update daily_raw_matches set season_id = 5, season2 = '2025/2026' where match_season = '2025';
update daily_raw_matches set season_id = 6, season2 = '2026/2027' where match_season = '2026';

update daily_raw_matches
set match_date2 = to_char(
  to_date(
    case
      when extract(month from to_date(split_part(match_date, ' ', 2) || ' ' || split_part(match_date, ' ', 4), 'DD Month')) >= 7
      then split_part(season2, '/', 1)
      else split_part(season2, '/', 2)
    end || ' ' || split_part(match_date, ' ', 2) || ' ' || split_part(match_date, ' ', 4), 'YYYY DD Month'
  ), 'YYYY-MM-DD')::date
;
