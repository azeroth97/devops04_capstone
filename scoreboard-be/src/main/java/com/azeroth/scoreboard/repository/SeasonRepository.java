package com.azeroth.scoreboard.repository;

import java.util.List;
import javax.sql.DataSource;
import com.azeroth.scoreboard.dto.WeekDTO;
import com.azeroth.scoreboard.dto.SeasonDTO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SeasonRepository {
  private final JdbcTemplate jdbc;

  public SeasonRepository(DataSource dataSource) {
    this.jdbc = new JdbcTemplate(dataSource);
  }

  public String getSeasonById(Integer seasonId) {
    String sql = "select name from seasons where id = ?";
    
    try {
      return jdbc.queryForObject(sql, String.class, seasonId);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  public List<SeasonDTO> getSeasons() {
    String sql = "select id, alias as name from seasons order by alias desc";

    return jdbc.query(sql, (rs, rowNum) -> {
      SeasonDTO dto = new SeasonDTO();
      dto.setId(rs.getInt("id"));
      dto.setName(rs.getString("name"));
      return dto;
    });
  }

  public List<WeekDTO> getWeeks(Integer leagueId, Integer seasonId) {
    String sql = """
      select distinct
          match_week as id
        , lpad(match_week::text, 2, '0') as name
      from matches
      where league_id = ?
        and season_id = ?
      order by match_week;
    """;

    return jdbc.query(sql, (rs, rowNum) -> {
      WeekDTO dto = new WeekDTO();
      dto.setId(rs.getInt("id"));
      dto.setName(rs.getString("name"));
      return dto;
    }, leagueId, seasonId);
  }

  public WeekDTO getLatestWeek(Integer leagueId, Integer seasonId){
    String sql = """
      select distinct on (league_id, season_id)
          played as id
        , lpad(played::text, 2, '0') as name
      from ranks
      where league_id = ?
        and season_id = ?
      order by league_id, season_id, played desc;
    """;
    
    try{
      return jdbc.queryForObject(sql, (rs, rowNum) -> {
        WeekDTO dto = new WeekDTO();
        dto.setId(rs.getInt("id"));
        dto.setName(rs.getString("name"));
        return dto;
      }, leagueId, seasonId);
    } catch (EmptyResultDataAccessException e) {
      return null; 
    }
  }
}