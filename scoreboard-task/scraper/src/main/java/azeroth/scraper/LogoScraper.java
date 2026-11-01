package azeroth.scraper;

import org.jsoup.nodes.*;
import org.jsoup.select.*;
import azeroth.config.DBConnector;
import azeroth.config.JsoupConnector;
import azeroth.model.Logo;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class LogoScraper {
  private Document doc;
  private Connection conn;

  public LogoScraper() {}

  public void getData(String[] urls, String tableName) {
    try {
      conn = new DBConnector().psqlConnect();

      Statement stmt;
      stmt = conn.createStatement();
      String sql1 = String.format("""
        drop table if exists %s;
        create table %s(team text,logo text);"""
      , tableName, tableName);
      stmt.executeUpdate(sql1);

      int season = 2026;
      for (String url: urls) {
        System.out.println("Crawling Club Logos Season " + season);

        try {
          doc = new JsoupConnector().fetchPage(url);
        } catch (Exception e) {
          System.out.println("Failed to fetch: " + url);
          continue;
        }

        doc = new JsoupConnector().fetchPage(url);
        List<Logo> logos = new ArrayList<>();
        Elements logoElements = doc.select("tbody td img");
        // System.out.println(logoElements);
        
        for (Element logoElement : logoElements) {
          Logo logo = new Logo();
          Elements imgTag = logoElement.select("img");
          logo.setTeam(imgTag.get(0).attr("alt"));
          logo.setUrl(imgTag.get(0).attr("src"));
          logos.add(logo);
        }

        String sql2 = String.format("insert into %s(team, logo) values (?, ?);", tableName);
        PreparedStatement ps = conn.prepareStatement(sql2);

        for (Logo logo : logos) {
          ps.setString(1, logo.getTeam());
          ps.setString(2, logo.getUrl());
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
