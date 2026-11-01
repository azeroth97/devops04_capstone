alter table raw_epl_matches add column if not exists league_id int;
alter table raw_laliga_matches add column if not exists league_id int;
alter table raw_bundesliga_matches add column if not exists league_id int;
alter table raw_seriea_matches add column if not exists league_id int;
alter table raw_ligue1_matches add column if not exists league_id int;

update raw_epl_matches set league_id = 1;
update raw_laliga_matches set league_id = 2;
update raw_bundesliga_matches set league_id = 3;
update raw_seriea_matches set league_id = 4;
update raw_ligue1_matches set league_id = 5;

drop table if exists raw_matches;
select * into raw_matches
from raw_epl_matches
  union select * from raw_laliga_matches
  union select * from raw_bundesliga_matches
  union select * from raw_seriea_matches
  union select * from raw_ligue1_matches
;

alter table raw_matches
    add column host text
  , add column host_id int
  , add column host_score int
  , add column guest text
  , add column guest_id int
  , add column guest_score int
  , add column season_id int
;

update raw_matches set host = host_team;
update raw_matches set guest = guest_team;


----====
  -- premier-league
  update raw_matches set host = 'Brighton & Hove Albion' where host = 'Brighton';
  update raw_matches set host = 'Leeds United' where host = 'Leeds';
  update raw_matches set host = 'Leicester City' where host = 'Leicester';
  update raw_matches set host = 'Manchester City' where host = 'M. City';
  update raw_matches set host = 'Manchester United' where host = 'M. United';
  update raw_matches set host = 'Newcastle United' where host = 'Newcastle';
  update raw_matches set host = 'Sheffield United' where host = 'Sheffield Utd';
  update raw_matches set host = 'Tottenham Hotspur' where host = 'Tottenham';
  update raw_matches set host = 'West Ham United' where host = 'West Ham';
  update raw_matches set host = 'Wolverhampton Wanderers' where host = 'Wolves';
  update raw_matches set guest = 'Brighton & Hove Albion' where guest = 'Brighton';
  update raw_matches set guest = 'Leeds United' where guest = 'Leeds';
  update raw_matches set guest = 'Leicester City' where guest = 'Leicester';
  update raw_matches set guest = 'Manchester City' where guest = 'M. City';
  update raw_matches set guest = 'Manchester United' where guest = 'M. United';
  update raw_matches set guest = 'Newcastle United' where guest = 'Newcastle';
  update raw_matches set guest = 'Sheffield United' where guest = 'Sheffield Utd';
  update raw_matches set guest = 'Tottenham Hotspur' where guest = 'Tottenham';
  update raw_matches set guest = 'West Ham United' where guest = 'West Ham';
  update raw_matches set guest = 'Wolverhampton Wanderers' where guest = 'Wolves';

  -- laliga
  update raw_matches set host = 'Deportivo Alavés' where host = 'Alavés';
  update raw_matches set host = 'UD Almería' where host = 'Almería';
  update raw_matches set host = 'Athletic Club' where host = 'Athletic';
  update raw_matches set host = 'Atlético Madrid' where host = 'Atlético';
  update raw_matches set host = 'FC Barcelona' where host = 'Barcelona';
  update raw_matches set host = 'Real Betis' where host = 'Betis';
  update raw_matches set host = 'Cádiz CF' where host = 'Cádiz';
  update raw_matches set host = 'RC Celta' where host = 'Celta';
  update raw_matches set host = 'Elche CF' where host = 'Elche';
  update raw_matches set host = 'RCD Espanyol' where host = 'Espanyol';
  update raw_matches set host = 'Getafe CF' where host = 'Getafe';
  update raw_matches set host = 'Girona FC' where host = 'Girona';
  update raw_matches set host = 'Granada CF' where host = 'Granada';
  update raw_matches set host = 'UD Las Palmas' where host = 'Las Palmas';
  update raw_matches set host = 'CD Leganés' where host = 'Leganés';
  update raw_matches set host = 'Levante UD' where host = 'Levante';
  update raw_matches set host = 'RCD Mallorca' where host = 'Mallorca';
  update raw_matches set host = 'CA Osasuna' where host = 'Osasuna';
  update raw_matches set host = 'Real Oviedo' where host = 'Oviedo';
  update raw_matches set host = 'Rayo Vallecano' where host = 'Rayo';
  update raw_matches set host = 'Real Sociedad' where host = 'R. Sociedad';
  update raw_matches set host = 'Sevilla FC' where host = 'Sevilla';
  update raw_matches set host = 'Valencia CF' where host = 'Valencia';
  update raw_matches set host = 'Villarreal CF' where host = 'Villarreal';
  update raw_matches set guest = 'Deportivo Alavés' where guest = 'Alavés';
  update raw_matches set guest = 'UD Almería' where guest = 'Almería';
  update raw_matches set guest = 'Athletic Club' where guest = 'Athletic';
  update raw_matches set guest = 'Atlético Madrid' where guest = 'Atlético';
  update raw_matches set guest = 'FC Barcelona' where guest = 'Barcelona';
  update raw_matches set guest = 'Real Betis' where guest = 'Betis';
  update raw_matches set guest = 'Cádiz CF' where guest = 'Cádiz';
  update raw_matches set guest = 'RC Celta' where guest = 'Celta';
  update raw_matches set guest = 'Elche CF' where guest = 'Elche';
  update raw_matches set guest = 'RCD Espanyol' where guest = 'Espanyol';
  update raw_matches set guest = 'Getafe CF' where guest = 'Getafe';
  update raw_matches set guest = 'Girona FC' where guest = 'Girona';
  update raw_matches set guest = 'Granada CF' where guest = 'Granada';
  update raw_matches set guest = 'UD Las Palmas' where guest = 'Las Palmas';
  update raw_matches set guest = 'CD Leganés' where guest = 'Leganés';
  update raw_matches set guest = 'Levante UD' where guest = 'Levante';
  update raw_matches set guest = 'RCD Mallorca' where guest = 'Mallorca';
  update raw_matches set guest = 'CA Osasuna' where guest = 'Osasuna';
  update raw_matches set guest = 'Real Oviedo' where guest = 'Oviedo';
  update raw_matches set guest = 'Rayo Vallecano' where guest = 'Rayo';
  update raw_matches set guest = 'Real Sociedad' where guest = 'R. Sociedad';
  update raw_matches set guest = 'Sevilla FC' where guest = 'Sevilla';
  update raw_matches set guest = 'Valencia CF' where guest = 'Valencia';
  update raw_matches set guest = 'Villarreal CF' where guest = 'Villarreal';

  -- bundesliga
  update raw_matches set host = '1. FC Heidenheim' where host = '1. FC Heidenheim 1846';
  update raw_matches set host = 'Arminia Bielefeld' where host = 'Arminia B.';
  update raw_matches set host = 'FC Augsburg' where host = 'Augsburgo';
  update raw_matches set host = 'FC Bayern Munich' where host = 'Bayern';
  update raw_matches set host = 'Borussia Dortmund' where host = 'B. Dortmund';
  update raw_matches set host = 'Borussia M’gladbach' where host = 'B. MGladbach';
  update raw_matches set host = 'VfL Bochum' where host = 'Bochum';
  update raw_matches set host = '1. FC Köln' where host = 'Colonia';
  update raw_matches set host = 'SV Darmstadt 98' where host = 'Darmstadt 98';
  update raw_matches set host = 'Eintracht Frankfurt' where host = 'Eintracht Fr.';
  update raw_matches set host = 'SC Freiburg' where host = 'Friburgo';
  update raw_matches set host = 'SpVgg Greuther Fürth' where host = 'Greuther Fürth';
  update raw_matches set host = 'Hamburger SV' where host = 'Hamburgo';
  update raw_matches set host = 'Hertha Berlin' where host = 'Hertha';
  update raw_matches set host = 'TSG 1899 Hoffenheim' where host = 'Hoffenheim';
  update raw_matches set host = 'Bayer 04 Leverkusen' where host = 'Leverkusen';
  update raw_matches set host = '1. FSV Mainz 05' where host = 'Mainz 05';
  update raw_matches set host = 'FC Schalke 04' where host = 'Schalke 04';
  update raw_matches set host = 'FC St. Pauli' where host = 'St. Pauli';
  update raw_matches set host = 'VfB Stuttgart' where host = 'Stuttgart';
  update raw_matches set host = '1. FC Union Berlin' where host = 'Unión Berlín';
  update raw_matches set host = 'Werder Bremen' where host = 'W. Bremen';
  update raw_matches set host = 'VfL Wolfsburg' where host = 'Wolfsburgo';
  update raw_matches set guest = '1. FC Heidenheim' where guest = '1. FC Heidenheim 1846';
  update raw_matches set guest = 'Arminia Bielefeld' where guest = 'Arminia B.';
  update raw_matches set guest = 'FC Augsburg' where guest = 'Augsburgo';
  update raw_matches set guest = 'FC Bayern Munich' where guest = 'Bayern';
  update raw_matches set guest = 'Borussia Dortmund' where guest = 'B. Dortmund';
  update raw_matches set guest = 'Borussia M’gladbach' where guest = 'B. MGladbach';
  update raw_matches set guest = 'VfL Bochum' where guest = 'Bochum';
  update raw_matches set guest = '1. FC Köln' where guest = 'Colonia';
  update raw_matches set guest = 'SV Darmstadt 98' where guest = 'Darmstadt 98';
  update raw_matches set guest = 'Eintracht Frankfurt' where guest = 'Eintracht Fr.';
  update raw_matches set guest = 'SC Freiburg' where guest = 'Friburgo';
  update raw_matches set guest = 'SpVgg Greuther Fürth' where guest = 'Greuther Fürth';
  update raw_matches set guest = 'Hamburger SV' where guest = 'Hamburgo';
  update raw_matches set guest = 'Hertha Berlin' where guest = 'Hertha';
  update raw_matches set guest = 'TSG 1899 Hoffenheim' where guest = 'Hoffenheim';
  update raw_matches set guest = 'Bayer 04 Leverkusen' where guest = 'Leverkusen';
  update raw_matches set guest = '1. FSV Mainz 05' where guest = 'Mainz 05';
  update raw_matches set guest = 'FC Schalke 04' where guest = 'Schalke 04';
  update raw_matches set guest = 'FC St. Pauli' where guest = 'St. Pauli';
  update raw_matches set guest = 'VfB Stuttgart' where guest = 'Stuttgart';
  update raw_matches set guest = '1. FC Union Berlin' where guest = 'Unión Berlín';
  update raw_matches set guest = 'Werder Bremen' where guest = 'W. Bremen';
  update raw_matches set guest = 'VfL Wolfsburg' where guest = 'Wolfsburgo';

  -- serie-a
  update raw_matches set host = 'Bologna' where host = 'Bolonia';
  update raw_matches set host = 'Como' where host = 'Como 1907';
  update raw_matches set host = 'Internazionale' where host = 'Inter';
  update raw_matches set host = 'SS Lazio' where host = 'Lazio';
  update raw_matches set host = 'AC Milan' where host = 'Milan';
  update raw_matches set host = 'Napoli' where host = 'Nápoles';
  update raw_matches set host = 'AS Roma' where host = 'Roma';
  update raw_matches set host = 'Hellas Verona' where host = 'Verona';
  update raw_matches set guest = 'Bologna' where guest = 'Bolonia';
  update raw_matches set guest = 'Como' where guest = 'Como 1907';
  update raw_matches set guest = 'Internazionale' where guest = 'Inter';
  update raw_matches set guest = 'SS Lazio' where guest = 'Lazio';
  update raw_matches set guest = 'AC Milan' where guest = 'Milan';
  update raw_matches set guest = 'Napoli' where guest = 'Nápoles';
  update raw_matches set guest = 'AS Roma' where guest = 'Roma';
  update raw_matches set guest = 'Hellas Verona' where guest = 'Verona';

  -- ligue-1
  update raw_matches set host = 'Angers SCO' where host = 'Angers';
  update raw_matches set host = 'AJ Auxerre' where host = 'Auxerre';
  update raw_matches set host = 'Stade Brestois' where host = 'Brest';
  update raw_matches set host = 'Clermont Foot' where host = 'Clermont';
  update raw_matches set host = 'RC Strasbourg Alsace' where host = 'Estrasburgo';
  update raw_matches set host = 'AC Ajaccio' where host = 'Gazélec Ajaccio';
  update raw_matches set host = 'Girondins de Bordeaux' where host = 'Girondins';
  update raw_matches set host = 'Le Havre AC' where host = 'Le Havre';
  update raw_matches set host = 'RC Lens' where host = 'Lens';
  update raw_matches set host = 'Lille OSC' where host = 'Lille';
  update raw_matches set host = 'FC Lorient' where host = 'Lorient';
  update raw_matches set host = 'Olympique Lyonnais' where host = 'Lyon';
  update raw_matches set host = 'Olympique de Marseille' where host = 'Marsella';
  update raw_matches set host = 'FC Metz' where host = 'Metz';
  update raw_matches set host = 'AS Monaco' where host = 'Monaco';
  update raw_matches set host = 'Montpellier HSC' where host = 'Montpellier';
  update raw_matches set host = 'FC Nantes' where host = 'Nantes';
  update raw_matches set host = 'OGC Nice' where host = 'Niza';
  update raw_matches set host = 'Paris FC' where host = 'París FC';
  update raw_matches set host = 'Paris Saint-Germain' where host = 'PSG';
  update raw_matches set host = 'Stade Rennais' where host = 'Rennes';
  update raw_matches set host = 'AS Saint-Etienne' where host = 'Saint-Etienne';
  update raw_matches set host = 'Toulouse FC' where host = 'Toulouse';
  update raw_matches set host = 'ESTAC Troyes' where host = 'Troyes';
  update raw_matches set guest = 'Angers SCO' where guest = 'Angers';
  update raw_matches set guest = 'AJ Auxerre' where guest = 'Auxerre';
  update raw_matches set guest = 'Stade Brestois' where guest = 'Brest';
  update raw_matches set guest = 'Clermont Foot' where guest = 'Clermont';
  update raw_matches set guest = 'RC Strasbourg Alsace' where guest = 'Estrasburgo';
  update raw_matches set guest = 'AC Ajaccio' where guest = 'Gazélec Ajaccio';
  update raw_matches set guest = 'Girondins de Bordeaux' where guest = 'Girondins';
  update raw_matches set guest = 'Le Havre AC' where guest = 'Le Havre';
  update raw_matches set guest = 'RC Lens' where guest = 'Lens';
  update raw_matches set guest = 'Lille OSC' where guest = 'Lille';
  update raw_matches set guest = 'FC Lorient' where guest = 'Lorient';
  update raw_matches set guest = 'Olympique Lyonnais' where guest = 'Lyon';
  update raw_matches set guest = 'Olympique de Marseille' where guest = 'Marsella';
  update raw_matches set guest = 'FC Metz' where guest = 'Metz';
  update raw_matches set guest = 'AS Monaco' where guest = 'Monaco';
  update raw_matches set guest = 'Montpellier HSC' where guest = 'Montpellier';
  update raw_matches set guest = 'FC Nantes' where guest = 'Nantes';
  update raw_matches set guest = 'OGC Nice' where guest = 'Niza';
  update raw_matches set guest = 'Paris FC' where guest = 'París FC';
  update raw_matches set guest = 'Paris Saint-Germain' where guest = 'PSG';
  update raw_matches set guest = 'Stade Rennais' where guest = 'Rennes';
  update raw_matches set guest = 'AS Saint-Etienne' where guest = 'Saint-Etienne';
  update raw_matches set guest = 'Toulouse FC' where guest = 'Toulouse';
  update raw_matches set guest = 'ESTAC Troyes' where guest = 'Troyes';
----****


update raw_matches set result = replace(result, ' ', '');
update raw_matches set host_score = (string_to_array(result, '-'))[1]::int where result not ilike '%z%';
update raw_matches set guest_score = (string_to_array(result, '-'))[2]::int where result not ilike '%z%';


alter table raw_matches add column season2 text;
alter table raw_matches add column match_date2 date;

update raw_matches set season_id = 1, season2 = '2021/2022' where match_season = '2021';
update raw_matches set season_id = 2, season2 = '2022/2023' where match_season = '2022';
update raw_matches set season_id = 3, season2 = '2023/2024' where match_season = '2023';
update raw_matches set season_id = 4, season2 = '2024/2025' where match_season = '2024';
update raw_matches set season_id = 5, season2 = '2025/2026' where match_season = '2025';

update raw_matches
set match_date2 = to_char(
  to_date(
    case
      when extract(month from to_date(split_part(match_date, ' ', 2) || ' ' || split_part(match_date, ' ', 4), 'DD Month')) >= 7
      then split_part(season2, '/', 1)
      else split_part(season2, '/', 2)
    end || ' ' || split_part(match_date, ' ', 2) || ' ' || split_part(match_date, ' ', 4), 'YYYY DD Month'
  ), 'YYYY-MM-DD')::date
;