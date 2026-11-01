package azeroth;

import azeroth.config.DataSource;
import azeroth.scraper.MatchScraper;
// import azeroth.scraper.RankingScraper;
// import azeroth.scraper.LogoScraper;

public class ScoreboardCrawler {
  public static void main(String[] args) {

    // RankingScraper rankingScraper = new RankingScraper();
    // LogoScraper logoScraper = new LogoScraper();
    MatchScraper matchScraper = new MatchScraper();

    System.out.println("====> Begin Crawling Matches at " + java.time.LocalDateTime.now());
    System.out.println("\nCrawling EPL Matches");
    matchScraper.getData(DataSource.current_season_epl_match_urls, DataSource.daily_epl_matches_table);
    System.out.println("\nCrawling Laliga Matches");
    matchScraper.getData(DataSource.current_season_laliga_match_urls, DataSource.daily_laliga_matches_table);
    System.out.println("\nCrawling Bundesliga Matches");
    matchScraper.getData(DataSource.current_season_bundesliga_match_urls, DataSource.daily_bundesliga_matches_table);
    System.out.println("\nCrawling Serie-A Matches");
    matchScraper.getData(DataSource.current_season_seriea_match_urls, DataSource.daily_seriea_matches_table);
    System.out.println("\nCrawling Ligue-1 Matches");
    matchScraper.getData(DataSource.current_season_ligue1_match_urls, DataSource.daily_ligue1_matches_table);
    System.out.println("\n====> End Crawling Matches at " + java.time.LocalDateTime.now());
    System.out.println("\n\n");

    // System.out.println("====> Begin Crawling Ranking Infos at " + java.time.LocalDateTime.now());
    // System.out.println("\nCrawling EPL Rankings");
    // rankingScraper.getData(DataSource.epl_ranking_urls, DataSource.epl_rankings_table);
    // System.out.println("\nCrawling Laliga Rankings");
    // rankingScraper.getData(DataSource.laliga_ranking_urls, DataSource.laliga_rankings_table);
    // System.out.println("\nCrawling Bundesliga Rankings");
    // rankingScraper.getData(DataSource.bundesliga_ranking_urls, DataSource.bundesliga_rankings_table);
    // System.out.println("\nCrawling Serie-A Rankings");
    // rankingScraper.getData(DataSource.seriea_ranking_urls, DataSource.seriea_rankings_table);
    // System.out.println("\nCrawling Ligue-1 Rankings");
    // rankingScraper.getData(DataSource.ligue1_ranking_urls, DataSource.ligue1_rankings_table);
    // System.out.println("\n====> End Crawling Ranking Infos at " + java.time.LocalDateTime.now());
    // System.out.println("\n\n");

    // System.out.println("====> Begin Crawling Logos at " + java.time.LocalDateTime.now());
    // System.out.println("\nCrawling EPL Logos");
    // logoScraper.getData(DataSource.epl_logo_urls, DataSource.epl_logos_table);
    // System.out.println("\nCrawling Laliga Logos");
    // logoScraper.getData(DataSource.laliga_logo_urls, DataSource.laliga_logos_table);
    // System.out.println("\nCrawling Bundesliga Logos");
    // logoScraper.getData(DataSource.bundesliga_logo_urls, DataSource.bundesliga_logos_table);
    // System.out.println("\nCrawling Serie-A Logos");
    // logoScraper.getData(DataSource.seriea_logo_urls, DataSource.seriea_logos_table);
    // System.out.println("\nCrawling Ligue-1 Logos");
    // logoScraper.getData(DataSource.ligue1_logo_urls, DataSource.ligue1_logos_table);
    // System.out.println("\n====> End Crawling Logos at " + java.time.LocalDateTime.now());
    // System.out.println("\n\n");

    // System.out.println("====> Begin Crawling Matches at " + java.time.LocalDateTime.now());
    // System.out.println("\nCrawling EPL Matches");
    // matchScraper.getData(DataSource.epl_match_urls, DataSource.epl_matches_table);
    // System.out.println("\nCrawling Laliga Matches");
    // matchScraper.getData(DataSource.laliga_match_urls, DataSource.laliga_matches_table);
    // System.out.println("\nCrawling Bundesliga Matches");
    // matchScraper.getData(DataSource.bundesliga_match_urls, DataSource.bundesliga_matches_table);
    // System.out.println("\nCrawling Serie-A Matches");
    // matchScraper.getData(DataSource.seriea_match_urls, DataSource.seriea_matches_table);
    // System.out.println("\nCrawling Ligue-1 Matches");
    // matchScraper.getData(DataSource.ligue1_match_urls, DataSource.ligue1_matches_table);
    // System.out.println("\n====> End Crawling Matches at " + java.time.LocalDateTime.now());
    // System.out.println("\n\n");
  }
}


