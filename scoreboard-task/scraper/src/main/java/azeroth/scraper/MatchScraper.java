package azeroth.scraper;

import org.jsoup.nodes.*;
import org.jsoup.select.*;
import azeroth.config.DBConnector;
import azeroth.config.JsoupConnector;
import azeroth.model.Match;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class MatchScraper {
  private Document doc;
  private Connection conn;

  public MatchScraper() {}

  public void getData(String[] urls, String tableName) {
    try {
      conn = new DBConnector().psqlConnect();

      Statement stmt;
      stmt = conn.createStatement();
      String sql1 = String.format("""
        drop table if exists %s;
        create table %s(
            match_season text
          ,	match_week text
          ,	match_date text
          ,	host_team text
          ,	guest_team text
          ,	result text
          ,	status text
        );"""
      , tableName, tableName);
      stmt.executeUpdate(sql1);


      // get current week
      String sql = """
          select max(played) as current_week
          from ranks
          where season_id = ? and league_id = ?
          """;
      int currentWeek;
      try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, 6);   // season_id
        ps.setInt(2, 1);   // league_id
        try (ResultSet rs = ps.executeQuery()) {
          currentWeek = rs.next() ? rs.getInt("current_week") : 0;
        }
      }

      int finalWeek = currentWeek + 5;

      // int finalWeek = 40;
      int season = 2026;
      for (String url: urls) {
        System.out.println("Crawling Matches Season " + season);

        int week = 1;
        while (week < finalWeek) {
          String weekUrl = url + "regular_a_" + week;
          try {
            doc = new JsoupConnector().fetchPage(weekUrl);
          } catch (Exception e) {
            System.out.println("Failed to fetch: " + weekUrl);
            break;
          }

          System.out.println("-->> crawling data week " + week);
          List<Match> matches = new ArrayList<>();
          Elements matchElements = doc.select("div.a_sd");
          // System.out.println(matchElements);
          
          for (Element matchElement : matchElements) {
            String matchDate = matchElement.selectFirst("h2").text();

            String matchStatus;
            try {
              matchStatus = matchElement.selectFirst("div.a_sc_st").text();
            } catch (Exception e) {
              matchStatus = "Upcoming";
            }
            
            Elements matchInfos = matchElement.select("li.a_sc_l_it");
            for (Element matchInfo : matchInfos){
              Match match = new Match();
              Elements matchTeams = matchInfo.select("span.a_sc_tn");

              String matchResult;
              try {
                matchResult = matchInfo.selectFirst("a.st-pt").text();
              } catch (Exception e) {
                matchResult = "z - z";
              }

              match.setMatchSeason(Integer.toString(season));
              match.setMatchWeek(Integer.toString(week));
              match.setMatchDate(matchDate);
              match.setHostTeam(matchTeams.get(0).text());
              match.setGuestTeam(matchTeams.get(1).text());
              match.setResult(matchResult);
              match.setStatus(matchStatus);
              matches.add(match);
            }
          }

          String sql2 = String.format("""
            insert into %s(
                match_season
              ,	match_week
              , match_date
              , host_team
              , guest_team
              , result
              , status
            ) values (?, ?, ?, ?, ?, ?, ?);"""
          , tableName);
          PreparedStatement ps = conn.prepareStatement(sql2);

          for (Match match : matches) {
            ps.setString(1, match.getMatchSeason());
            ps.setString(2, match.getMatchWeek());
            ps.setString(3, match.getMatchDate());
            ps.setString(4, match.getHostTeam());
            ps.setString(5, match.getGuestTeam());
            ps.setString(6, match.getResult());
            ps.setString(7, match.getStatus());
            ps.addBatch();
          }
          ps.executeBatch();

          week++;
        }
        season--;
      }
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }
}
