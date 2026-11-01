package com.azeroth.scoreboard.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.azeroth.scoreboard.dto.RankingDTO;
import com.azeroth.scoreboard.model.League;
import com.azeroth.scoreboard.service.LeagueService;
import com.azeroth.scoreboard.service.SeasonService;

@RestController
public class LeagueController {
  private final LeagueService leagueService;
  private final SeasonService seasonService;

  public LeagueController(LeagueService leagueService, SeasonService seasonService) {
    this.leagueService = leagueService;
    this.seasonService = seasonService;
  }

  @GetMapping("/leagues")
  public List<League> getAllLeagues(){
    return leagueService.findAllLeagues();
  }

  @GetMapping("/leagues/{leagueId}/seasons/{seasonId}")
  public List<RankingDTO> getStandings(@PathVariable Integer leagueId, @PathVariable Integer seasonId) {
    String league = leagueService.findLeague(leagueId).getAlias();
    String season = seasonService.findSeason(seasonId);
    List<RankingDTO> infos = leagueService.getRankings(league, season);
    return infos;
  }
}
