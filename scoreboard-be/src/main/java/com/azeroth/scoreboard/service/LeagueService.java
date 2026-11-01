package com.azeroth.scoreboard.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.azeroth.scoreboard.dto.RankingDTO;
import com.azeroth.scoreboard.model.League;
import com.azeroth.scoreboard.repository.LeagueRepository;
import com.azeroth.scoreboard.repository.RankingRepository;

@Service
public class LeagueService {
  private LeagueRepository leagueRepository;
  private RankingRepository rankingRepository;

  public LeagueService(LeagueRepository leagueRepository, RankingRepository rankingRepository) {
    this.leagueRepository = leagueRepository;
    this.rankingRepository = rankingRepository;
  }

  public List<League> findAllLeagues() {
    return leagueRepository.findAll();
  }

  public League findLeague(Integer leagueId) {
    Optional<League> optionalLeague = leagueRepository.findById(leagueId);
    League league = optionalLeague.orElseThrow(() -> new IllegalArgumentException(
      "League not found with id: " + leagueId + ". Please ensure the ID is correct "
    ));
    return league;
  }

  public List<RankingDTO> getRankings(String league, String season) {
    return rankingRepository.getRankings(league, season);
  }
}
