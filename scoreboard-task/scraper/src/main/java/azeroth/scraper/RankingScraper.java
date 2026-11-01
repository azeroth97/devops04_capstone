package azeroth.scraper;

import org.jsoup.nodes.*;
import org.jsoup.select.*;
import azeroth.config.DBConnector;
import azeroth.config.JsoupConnector;
import azeroth.model.Ranking;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class RankingScraper {
  private Document doc;
  private Connection conn;

  public RankingScraper() {}

  public void getData(String[] urls, String tableName) {
    try {
      conn = new DBConnector().psqlConnect();

      Statement stmt;
      stmt = conn.createStatement();
      String sql1 = String.format("""
        drop table if exists %s;
        create table %s (
          season text, position text, team text, played text
          , win text,	draw text, lose text, gf text, ga text, pts text
        );"""
      , tableName, tableName);
      stmt.executeUpdate(sql1);

      int season = 2025;
      for (String url: urls) {
        System.out.println("Crawling Club Rankings Season " + season);

        doc = new JsoupConnector().fetchPage(url);
        List<Ranking> infos = new ArrayList<>();
        Elements infoElements = doc.select("tr.bg-neutral-01");
        System.out.println(infoElements);
        for (Element infoElement : infoElements) {
          Ranking info = new Ranking();
          Elements tds = infoElement.select("td");

          info.setPosition(tds.get(1).text());
          info.setTeam(tds.get(3).selectFirst("a").text());
          info.setLogo(tds.get(3).select("img").attr("src"));
          info.setPlayed(tds.get(5).text());
          info.setWins(tds.get(6).text());
          info.setDraws(tds.get(7).text());
          info.setLosses(tds.get(8).text());
          info.setGoalsFor(tds.get(9).text());
          info.setGoalsAgainst(tds.get(10).text());
          info.setPoints(tds.get(12).text());
          infos.add(info);
        }

        String sql2 = String.format("""
            insert into %s(position, team, played, win, draw, lose, gf, ga, pts, season)
            values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
        """, tableName);
        PreparedStatement ps = conn.prepareStatement(sql2);

        for (Ranking info : infos) {
          ps.setString(1, info.getPosition());
          ps.setString(2, info.getTeam());
          ps.setString(3, info.getPlayed());
          ps.setString(4, info.getWins());
          ps.setString(5, info.getDraws());
          ps.setString(6, info.getLosses());
          ps.setString(7, info.getGoalsFor());
          ps.setString(8, info.getGoalsAgainst());
          ps.setString(9, info.getPoints());
          ps.setString(10, String.valueOf(season));
          ps.addBatch();
        }
        ps.executeBatch();
        season--;
      }
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }
}
