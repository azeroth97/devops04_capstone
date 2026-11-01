package com.azeroth.scoreboard.controller;

import java.util.List;
import com.azeroth.scoreboard.dto.SeasonDTO;
import com.azeroth.scoreboard.service.SeasonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeasonController {
  private final SeasonService seasonService;

  public SeasonController(SeasonService seasonService) {
    this.seasonService = seasonService;
  }

  @GetMapping("/seasons")
  public List<SeasonDTO> getSeasons() {
    return seasonService.getSeasons();
  }
}