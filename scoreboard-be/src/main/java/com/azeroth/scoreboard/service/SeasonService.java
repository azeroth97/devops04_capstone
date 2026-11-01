package com.azeroth.scoreboard.service;

import java.util.List;
import com.azeroth.scoreboard.dto.WeekDTO;
import com.azeroth.scoreboard.dto.SeasonDTO;
import com.azeroth.scoreboard.repository.SeasonRepository;
import org.springframework.stereotype.Service;

@Service
public class SeasonService {
  private SeasonRepository seasonRepository;

  public SeasonService(SeasonRepository seasonRepository) {
    this.seasonRepository = seasonRepository;
  }

  public String findSeason(Integer seasonId) {
    return seasonRepository.getSeasonById(seasonId);
  }

  public List<SeasonDTO> getSeasons() {
    return seasonRepository.getSeasons();
  }

  public List<WeekDTO> getWeeks(Integer leagueId, Integer seasonId) {
    return seasonRepository.getWeeks(leagueId, seasonId);
  }

  public WeekDTO getLatestWeek(Integer leagueId, Integer seasonId) {
    return seasonRepository.getLatestWeek(leagueId, seasonId);
  }
}