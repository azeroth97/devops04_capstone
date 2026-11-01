package com.azeroth.scoreboard.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class RankingDTO {
  private Integer rankId;
  private String leagueName;
  private String seasonName;
  private String teamName;
  private String logo;
  private Integer position;
  private Integer played;
  private Integer wins;
  private Integer draws;
  private Integer losses;
  private Integer goalsFor;
  private Integer goalsAgainst;
  private Integer goalsDiff;
  private Integer points;
  private Integer positionChange;
  private String formResults;
  private String nextOpponentLogo;
}
