package azeroth.config;

import java.util.Arrays;

public class DataSource {
  public static String epl_rankings_table = "raw_epl_rankings";
  public static String laliga_rankings_table = "raw_laliga_rankings";
  public static String bundesliga_rankings_table = "raw_bundesliga_rankings";
  public static String seriea_rankings_table = "raw_seriea_rankings";
  public static String ligue1_rankings_table = "raw_ligue1_rankings";

  public static String epl_logos_table = "raw_epl_logos";
  public static String laliga_logos_table = "raw_laliga_logos";
  public static String bundesliga_logos_table = "raw_bundesliga_logos";
  public static String seriea_logos_table = "raw_seriea_logos";
  public static String ligue1_logos_table = "raw_ligue1_logos";

  public static String epl_matches_table = "raw_epl_matches";
  public static String laliga_matches_table = "raw_laliga_matches";
  public static String bundesliga_matches_table = "raw_bundesliga_matches";
  public static String seriea_matches_table = "raw_seriea_matches";
  public static String ligue1_matches_table = "raw_ligue1_matches";


  public static String daily_epl_matches_table = "daily_epl_matches";
  public static String daily_laliga_matches_table = "daily_laliga_matches";
  public static String daily_bundesliga_matches_table = "daily_bundesliga_matches";
  public static String daily_seriea_matches_table = "daily_seriea_matches";
  public static String daily_ligue1_matches_table = "daily_ligue1_matches";

  //// Rankings
  public static String[] epl_ranking_urls = {
      "https://www.tntsports.co.uk/football/premier-league/2025-2026/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/premier-league/2024-2025/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/premier-league/2023-2024/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/premier-league/2022-2023/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/premier-league/2021-2022/standings.shtml"
  };

  public static String[] laliga_ranking_urls = {
      "https://www.tntsports.co.uk/football/la-liga/2025-2026/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/la-liga/2024-2025/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/la-liga/2023-2024/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/liga/2022-2023/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/liga/2021-2022/standings.shtml"
  };

  public static String[] bundesliga_ranking_urls = {
      "https://www.tntsports.co.uk/football/bundesliga/2025-2026/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/bundesliga/2024-2025/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/bundesliga/2023-2024/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/bundesliga/2022-2023/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/bundesliga/2021-2022/standings.shtml"
  };

  public static String[] seriea_ranking_urls = {
      "https://www.tntsports.co.uk/football/serie-a/2025-2026/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/serie-a/2024-2025/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/serie-a/2023-2024/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/serie-a/2022-2023/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/serie-a/2021-2022/standings.shtml"
  };

  public static String[] ligue1_ranking_urls = {
      "https://www.tntsports.co.uk/football/ligue-1/2025-2026/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/ligue-1/2024-2025/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/ligue-1/2023-2024/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/ligue-1/2022-2023/standings.shtml"
    ,	"https://www.tntsports.co.uk/football/ligue-1/2021-2022/standings.shtml"
  };

  public static String[] current_season_epl_ranking_urls = Arrays.copyOfRange(DataSource.epl_ranking_urls, 0, 1);
  public static String[] current_season_laliga_ranking_urls = Arrays.copyOfRange(DataSource.laliga_ranking_urls, 0, 1);
  public static String[] current_season_bundesliga_ranking_urls = Arrays.copyOfRange(DataSource.bundesliga_ranking_urls, 0, 1);
  public static String[] current_season_seriea_ranking_urls = Arrays.copyOfRange(DataSource.seriea_ranking_urls, 0, 1);
  public static String[] current_season_ligue1_ranking_urls = Arrays.copyOfRange(DataSource.ligue1_ranking_urls, 0, 1);


  //// Logos
  public static String[] epl_logo_urls = {
      "https://sports.yahoo.com/soccer/premier-league/standings/?season=2026"
    // , "https://sports.yahoo.com/soccer/premier-league/standings/?season=2025"
    // ,	"https://sports.yahoo.com/soccer/premier-league/standings/?season=2024"
    // ,	"https://sports.yahoo.com/soccer/premier-league/standings/?season=2023"
    // ,	"https://sports.yahoo.com/soccer/premier-league/standings/?season=2022"
    // ,	"https://sports.yahoo.com/soccer/premier-league/standings/?season=2021"
  };

  public static String[] laliga_logo_urls = {
      "https://sports.yahoo.com/soccer/la-liga/standings/?season=2026"
    // , "https://sports.yahoo.com/soccer/la-liga/standings/?season=2025"
    // ,	"https://sports.yahoo.com/soccer/la-liga/standings/?season=2024"
    // ,	"https://sports.yahoo.com/soccer/la-liga/standings/?season=2023"
    // ,	"https://sports.yahoo.com/soccer/la-liga/standings/?season=2022"
    // ,	"https://sports.yahoo.com/soccer/la-liga/standings/?season=2021"
  };

  public static String[] bundesliga_logo_urls = {
      "https://sports.yahoo.com/soccer/bundesliga/standings/?season=2026"
    // , "https://sports.yahoo.com/soccer/bundesliga/standings/?season=2025"
    // ,	"https://sports.yahoo.com/soccer/bundesliga/standings/?season=2024"
    // ,	"https://sports.yahoo.com/soccer/bundesliga/standings/?season=2023"
    // ,	"https://sports.yahoo.com/soccer/bundesliga/standings/?season=2022"
    // ,	"https://sports.yahoo.com/soccer/bundesliga/standings/?season=2021"
  };

  public static String[] seriea_logo_urls = {
      "https://sports.yahoo.com/soccer/serie-a/standings/?season=2026"
    // , "https://sports.yahoo.com/soccer/serie-a/standings/?season=2025"
    // ,	"https://sports.yahoo.com/soccer/serie-a/standings/?season=2024"
    // ,	"https://sports.yahoo.com/soccer/serie-a/standings/?season=2023"
    // ,	"https://sports.yahoo.com/soccer/serie-a/standings/?season=2022"
    // ,	"https://sports.yahoo.com/soccer/serie-a/standings/?season=2021"
  };

  public static String[] ligue1_logo_urls = {
      "https://sports.yahoo.com/soccer/ligue-1/standings/?season=2026"
    // , "https://sports.yahoo.com/soccer/ligue-1/standings/?season=2025"
    // ,	"https://sports.yahoo.com/soccer/ligue-1/standings/?season=2024"
    // ,	"https://sports.yahoo.com/soccer/ligue-1/standings/?season=2023"
    // ,	"https://sports.yahoo.com/soccer/ligue-1/standings/?season=2022"
    // ,	"https://sports.yahoo.com/soccer/ligue-1/standings/?season=2021"
  };


  //// Matches
  public static String[] epl_match_urls = {
      "https://en.as.com/resultados/futbol/inglaterra/2026_2027/jornada/"
    // , "https://en.as.com/resultados/futbol/inglaterra/2025_2026/jornada/"
    // ,	"https://en.as.com/resultados/futbol/inglaterra/2024_2025/jornada/"
    // ,	"https://en.as.com/resultados/futbol/inglaterra/2023_2024/jornada/"
    // ,	"https://en.as.com/resultados/futbol/inglaterra/2022_2023/jornada/"
    // ,	"https://en.as.com/resultados/futbol/inglaterra/2021_2022/jornada/"
  };

  public static String[] laliga_match_urls = {
      "https://en.as.com/resultados/futbol/primera/2026_2027/jornada/"
    // , "https://en.as.com/resultados/futbol/primera/2025_2026/jornada/"
    // ,	"https://en.as.com/resultados/futbol/primera/2024_2025/jornada/"
    // ,	"https://en.as.com/resultados/futbol/primera/2023_2024/jornada/"
    // ,	"https://en.as.com/resultados/futbol/primera/2022_2023/jornada/"
    // ,	"https://en.as.com/resultados/futbol/primera/2021_2022/jornada/"
  };

  public static String[] bundesliga_match_urls = {
      "https://en.as.com/resultados/futbol/alemania/2026_2027/jornada/"
    // , "https://en.as.com/resultados/futbol/alemania/2025_2026/jornada/"
    // ,	"https://en.as.com/resultados/futbol/alemania/2024_2025/jornada/"
    // ,	"https://en.as.com/resultados/futbol/alemania/2023_2024/jornada/"
    // ,	"https://en.as.com/resultados/futbol/alemania/2022_2023/jornada/"
    // ,	"https://en.as.com/resultados/futbol/alemania/2021_2022/jornada/"
  };

  public static String[] seriea_match_urls = {
      "https://en.as.com/resultados/futbol/italia/2026_2027/jornada/"
    // , "https://en.as.com/resultados/futbol/italia/2025_2026/jornada/"
    // ,	"https://en.as.com/resultados/futbol/italia/2024_2025/jornada/"
    // ,	"https://en.as.com/resultados/futbol/italia/2023_2024/jornada/"
    // ,	"https://en.as.com/resultados/futbol/italia/2022_2023/jornada/"
    // ,	"https://en.as.com/resultados/futbol/italia/2021_2022/jornada/"
  };

  public static String[] ligue1_match_urls = {
      "https://en.as.com/resultados/futbol/francia/2026_2027/jornada/"
    // , "https://en.as.com/resultados/futbol/francia/2025_2026/jornada/"
    // ,	"https://en.as.com/resultados/futbol/francia/2024_2025/jornada/"
    // ,	"https://en.as.com/resultados/futbol/francia/2023_2024/jornada/"
    // ,	"https://en.as.com/resultados/futbol/francia/2022_2023/jornada/"
    // ,	"https://en.as.com/resultados/futbol/francia/2021_2022/jornada/"
  };

  public static String[] current_season_epl_match_urls = Arrays.copyOfRange(DataSource.epl_match_urls, 0, 1);
  public static String[] current_season_laliga_match_urls = Arrays.copyOfRange(DataSource.laliga_match_urls, 0, 1);
  public static String[] current_season_bundesliga_match_urls = Arrays.copyOfRange(DataSource.bundesliga_match_urls, 0, 1);
  public static String[] current_season_seriea_match_urls = Arrays.copyOfRange(DataSource.seriea_match_urls, 0, 1);
  public static String[] current_season_ligue1_match_urls = Arrays.copyOfRange(DataSource.ligue1_match_urls, 0, 1);
}
