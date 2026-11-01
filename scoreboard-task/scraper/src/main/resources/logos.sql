alter table raw_epl_logos add column if not exists league_id int;
alter table raw_laliga_logos add column if not exists league_id int;
alter table raw_bundesliga_logos add column if not exists league_id int;
alter table raw_seriea_logos add column if not exists league_id int;
alter table raw_ligue1_logos add column if not exists league_id int;

update raw_epl_logos set league_id = 1;
update raw_laliga_logos set league_id = 2;
update raw_bundesliga_logos set league_id = 3;
update raw_seriea_logos set league_id = 4;
update raw_ligue1_logos set league_id = 5;

drop table if exists raw_logos;
select * into raw_logos
from raw_epl_logos
  union select * from raw_laliga_logos
  union select * from raw_bundesliga_logos
  union select * from raw_seriea_logos
  union select * from raw_ligue1_logos
;


update raw_logos set logo = replace(logo, 'background-image:url(', '');
update raw_logos set logo = replace(logo, ')', '');


----====
  -- premier-league
  update raw_logos set team = 'Brighton & Hove Albion' where team = 'Brighton and Hove Albion';

  -- laliga
  update raw_laliga_logos set team = 'Deportivo Alavés' where team = 'Alavés';
  update raw_laliga_logos set team = 'UD Almería' where team = 'Almería';
  update raw_laliga_logos set team = 'Atlético Madrid' where team = 'Atlético de Madrid';
  update raw_laliga_logos set team = 'FC Barcelona' where team = 'Barcelona';
  update raw_laliga_logos set team = 'Cádiz CF' where team = 'Cadiz';
  update raw_laliga_logos set team = 'RC Celta' where team = 'Celta de Vigo';
  update raw_laliga_logos set team = 'Elche CF' where team = 'Elche';
  update raw_laliga_logos set team = 'RCD Espanyol' where team = 'Espanyol';
  update raw_laliga_logos set team = 'Getafe CF' where team = 'Getafe';
  update raw_laliga_logos set team = 'Girona FC' where team = 'Girona';
  update raw_laliga_logos set team = 'UD Las Palmas' where team = 'Las Palmas';
  update raw_laliga_logos set team = 'CD Leganés' where team = 'Leganés';
  update raw_laliga_logos set team = 'Levante UD' where team = 'Levante';
  update raw_laliga_logos set team = 'RCD Mallorca' where team = 'Mallorca';
  update raw_laliga_logos set team = 'CA Osasuna' where team = 'Osasuna';
  update raw_laliga_logos set team = 'Sevilla FC' where team = 'Sevilla';
  update raw_laliga_logos set team = 'Villarreal CF' where team = 'Villarreal';

  -- bundesliga
  update raw_bundesliga_logos set team = 'TSG 1899 Hoffenheim' where team = '1899 Hoffenheim';
  update raw_bundesliga_logos set team = '1. FC Heidenheim' where team = '1. FC Heidenheim 1846';
  update raw_bundesliga_logos set team = 'Borussia M’gladbach' where team = 'Borussia Mönchengladbach';
  update raw_bundesliga_logos set team = 'Arminia Bielefeld' where team = 'DSC Arminia Bielefeld';
  update raw_bundesliga_logos set team = 'FC Bayern Munich' where team = 'FC Bayern München';
  update raw_bundesliga_logos set team = 'Hertha Berlin' where team = 'Hertha BSC';
  update raw_bundesliga_logos set team = 'Holstein Kiel' where team = 'Kiel';
  update raw_bundesliga_logos set team = 'SC Freiburg' where team = 'Sport-Club Freiburg';
  update raw_bundesliga_logos set team = 'Werder Bremen' where team = 'SV Werder Bremen';
  update raw_bundesliga_logos set team = 'VfL Bochum' where team = 'VfL Bochum 1848';

  -- serie-a
  update raw_seriea_logos set team = 'SS Lazio' where team = 'Lazio';
  update raw_seriea_logos set team = 'AC Milan' where team = 'Milan';
  update raw_seriea_logos set team = 'AS Roma' where team = 'Roma';
  update raw_seriea_logos set team = 'Hellas Verona' where team = 'Verona';

  -- ligue-1
  update raw_ligue1_logos set team = 'AC Ajaccio' where team = 'Ajaccio';
  update raw_ligue1_logos set team = 'Angers SCO' where team = 'Angers';
  update raw_ligue1_logos set team = 'AJ Auxerre' where team = 'Auxerre';
  update raw_ligue1_logos set team = 'Girondins de Bordeaux' where team = 'Bordeaux';
  update raw_ligue1_logos set team = 'Stade Brestois' where team ilike 'Brest%';
  update raw_ligue1_logos set team = 'Clermont Foot' where team = 'Clermont';
  update raw_ligue1_logos set team = 'Le Havre AC' where team = 'Le Havre';
  update raw_ligue1_logos set team = 'RC Lens' where team = 'Lens';
  update raw_ligue1_logos set team = 'Lille OSC' where team = 'Lille';
  update raw_ligue1_logos set team = 'FC Lorient' where team = 'Lorient';
  update raw_ligue1_logos set team = 'Olympique Lyonnais' where team = 'Lyon';
  update raw_ligue1_logos set team = 'Olympique de Marseille' where team = 'Marseille';
  update raw_ligue1_logos set team = 'FC Metz' where team = 'Metz';
  update raw_ligue1_logos set team = 'AS Monaco' where team = 'Monaco';
  update raw_ligue1_logos set team = 'Montpellier HSC' where team = 'Montpellier';
  update raw_ligue1_logos set team = 'FC Nantes' where team = 'Nantes';
  update raw_ligue1_logos set team = 'OGC Nice' where team = 'Nice';
  update raw_ligue1_logos set team = 'Paris FC' where team = 'Paris';
  update raw_ligue1_logos set team = 'Paris Saint-Germain' where team = 'Paris Saint Germain';
  update raw_ligue1_logos set team = 'Stade de Reims' where team = 'Reims';
  update raw_ligue1_logos set team = 'Stade Rennais' where team = 'Rennes';
  update raw_ligue1_logos set team = 'AS Saint-Etienne' where team = 'St Etienne';
  update raw_ligue1_logos set team = 'RC Strasbourg Alsace' where team = 'Strasbourg Alsace';
  update raw_ligue1_logos set team = 'Toulouse FC' where team = 'Toulouse';
  update raw_ligue1_logos set team = 'ESTAC Troyes' where team = 'Troyes';
----****

alter table raw_logos add team_id int;
truncate raw_logos restart identity;
insert into raw_logos select * from bk_raw_logos;