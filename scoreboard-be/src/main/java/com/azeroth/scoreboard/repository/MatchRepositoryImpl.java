package com.azeroth.scoreboard.repository;

import java.util.List;
import javax.sql.DataSource;
import com.azeroth.scoreboard.dto.MatchDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MatchRepositoryImpl implements MatchRepositoryCustom {
  private final JdbcTemplate jdbc;

  public MatchRepositoryImpl(DataSource dataSource) {
    this.jdbc = new JdbcTemplate(dataSource);
  }

  @Override
  public List<MatchDTO> getResults(String league, String season, Integer week) {
    String sql = """
      select
          m.id as match_id
        , m.match_week as week
        , to_char(m.match_date2, 'Dy DD Mon') as date
        , m.match_date2 as date2
        , l.name as league
        , s.name as season
        , h.name as host
        , h.logo as host_logo
        , m.host_score
        , g.name as guest
        , g.logo as guest_logo
        , m.guest_score
        , m.status
      from matches m
      join teams h on h.id = m.host_id
      join teams g on g.id = m.guest_id
      join leagues l on l.id = m.league_id
      join seasons s on s.id = m.season_id
      where l.alias = ? and s.name = ? and m.match_week = ?
      order by m.match_date2;
    """;
    
    return jdbc.query(sql, (rs, rowNum) -> {
      MatchDTO dto = new MatchDTO();
      dto.setMatchId(rs.getInt("match_id"));
      dto.setWeek(rs.getInt("week"));
      dto.setMatchDate(rs.getString("date"));
      dto.setMatchDate2(rs.getDate("date2").toLocalDate());
      dto.setLeagueName(rs.getString("league"));
      dto.setSeasonName(rs.getString("season"));
      dto.setHostName(rs.getString("host"));
      dto.setHostLogo(rs.getString("host_logo"));
      dto.setHostScore(rs.getInt("host_score"));
      dto.setGuestName(rs.getString("guest"));
      dto.setGuestLogo(rs.getString("guest_logo"));
      dto.setGuestScore(rs.getInt("guest_score"));
      dto.setStatus(rs.getString("status"));
      return dto;
    }, league, season, week);
  }
}
