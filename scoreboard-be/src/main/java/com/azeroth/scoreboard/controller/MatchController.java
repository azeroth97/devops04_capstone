package com.azeroth.scoreboard.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.azeroth.scoreboard.dto.MatchDTO;
import com.azeroth.scoreboard.dto.WeekDTO;
import com.azeroth.scoreboard.model.Match;
import com.azeroth.scoreboard.service.LeagueService;
import com.azeroth.scoreboard.service.MatchService;
import com.azeroth.scoreboard.service.SeasonService;

@RestController
public class MatchController {
  private final MatchService matchService;
  private final LeagueService leagueService;
  private final SeasonService seasonService;

  public MatchController(MatchService matchService,
                  LeagueService leagueService,
                  SeasonService seasonService) {
    this.matchService = matchService;
    this.leagueService = leagueService;
    this.seasonService = seasonService;
  }

  @GetMapping("/matches/{matchId}")
  public Match getMatch(@PathVariable Integer matchId) {
    return matchService.findMatch(matchId);
  }

  @GetMapping("/leagues/{leagueId}/seasons/{seasonId}/weeks")
  public List<WeekDTO> getWeeks(@PathVariable Integer leagueId, @PathVariable Integer seasonId) {
    return seasonService.getWeeks(leagueId, seasonId);
  }

  @GetMapping("/leagues/{leagueId}/seasons/{seasonId}/latest-week")
  public WeekDTO getLatestWeek(@PathVariable Integer leagueId, @PathVariable Integer seasonId) {
    return seasonService.getLatestWeek(leagueId, seasonId);
  }

  @GetMapping("/leagues/{leagueId}/seasons/{seasonId}/matches/{week}")
  public List<MatchDTO> getWeekMatches(@PathVariable Integer leagueId,
                                       @PathVariable Integer seasonId,
                                       @PathVariable Integer week) {
    String league = leagueService.findLeague(leagueId).getAlias();
    String season = seasonService.findSeason(seasonId);
    List<MatchDTO> infos = matchService.getResults(league, season, week);
    return infos;
  } 

  @PostMapping("/matches")
  Match newMatch(@RequestBody Match newMatch) {
    return matchService.saveMatch(newMatch);
  }

  @PutMapping("/matches/{matchId}")
  Match updateMatch(@RequestBody Match newMatch, @PathVariable Integer matchId) {
    Match match = matchService.findMatch(matchId);
    match.setHostScore(newMatch.getHostScore());
    match.setGuestScore(newMatch.getGuestScore());
    return matchService.saveMatch(match);
  }

  @PatchMapping("/matches/{matchId}")
  void changeStatus(@RequestBody Match newMatch, @PathVariable Integer matchId) {
    Match match = matchService.findMatch(matchId);
    match.setStatus(newMatch.getStatus());
    matchService.saveMatch(match);
  }

  @DeleteMapping("/matches/{matchId}")
  void deleteMatch(@PathVariable Integer matchId) {
    matchService.removeMatch(matchId);
  }
}
