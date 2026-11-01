package com.azeroth.scoreboard.repository;

import java.util.List;
import javax.sql.DataSource;
import com.azeroth.scoreboard.dto.RankingDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RankingRepository {
  private final JdbcTemplate jdbc;

  public RankingRepository(DataSource dataSource) {
    this.jdbc = new JdbcTemplate(dataSource);
  }
  
  public List<RankingDTO> getRankings(String league, String season) {
    String sql = """
      select
          r.id as rank_id
        , r.position
        , l.name as league
        , s.name as season
        , t.name as team
        , t.logo
        , r.played
        , r.wins
        , r.draws
        , r.losses
        , r.goals_for
        , r.goals_against
        , r.goals_diff
        , r.points
        , r.position_change
        , r.form_results
        , coalesce(t2.logo, '') as next_opponent_logo
      from ranks r
      join teams t on t.id = r.team_id
      join leagues l on l.id = r.league_id
      join seasons s on s.id = r.season_id
      left join teams t2 on t2.id = r.next_opponent
      where l.alias = ? and s.name = ?
      order by r.position;
    """;
    
    return jdbc.query(sql, (rs, rowNum) -> {
      RankingDTO dto = new RankingDTO();
      dto.setRankId(rs.getInt("rank_id"));
      dto.setPosition(rs.getInt("position"));
      dto.setLeagueName(rs.getString("league"));
      dto.setSeasonName(rs.getString("season"));
      dto.setTeamName(rs.getString("team"));
      dto.setLogo(rs.getString("logo"));
      dto.setPlayed(rs.getInt("played"));
      dto.setWins(rs.getInt("wins"));
      dto.setDraws(rs.getInt("draws"));
      dto.setLosses(rs.getInt("losses"));
      dto.setGoalsFor(rs.getInt("goals_for"));
      dto.setGoalsAgainst(rs.getInt("goals_against"));
      dto.setGoalsDiff(rs.getInt("goals_diff"));
      dto.setPoints(rs.getInt("points"));
      dto.setPositionChange(rs.getInt("position_change"));
      dto.setFormResults(rs.getString("form_results"));
      dto.setNextOpponentLogo(rs.getString("next_opponent_logo"));
      return dto;
    }, league, season);
  }
}

