package com.azeroth.scoreboard.repository;

import java.util.List;
import com.azeroth.scoreboard.dto.MatchDTO;

public interface MatchRepositoryCustom {
  public List<MatchDTO> getResults(String league, String season, Integer week);
}