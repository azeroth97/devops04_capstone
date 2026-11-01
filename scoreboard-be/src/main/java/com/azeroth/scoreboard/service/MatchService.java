package com.azeroth.scoreboard.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.azeroth.scoreboard.dto.MatchDTO;
import com.azeroth.scoreboard.model.Match;
import com.azeroth.scoreboard.repository.MatchRepository;

@Service
public class MatchService {
  private MatchRepository matchRepository;

  public MatchService(MatchRepository matchRepository) {
    this.matchRepository = matchRepository;
  }

  public Match findMatch(Integer matchId) {
    Optional<Match> optionalMatch = matchRepository.findById(matchId);
    Match match = optionalMatch.orElseThrow(() -> new IllegalArgumentException(
      "Match not found with id: " + matchId + ". Please ensure the ID is correct "
    ));
    return match;
  }

  public Match saveMatch(Match newMatch) {
    return matchRepository.save(newMatch);
  }

  public void removeMatch(Integer matchId) {
    matchRepository.deleteById(matchId);
  }

  public List<MatchDTO> getResults(String league, String season, Integer week) {
    return matchRepository.getResults(league, season, week);
  }
}
