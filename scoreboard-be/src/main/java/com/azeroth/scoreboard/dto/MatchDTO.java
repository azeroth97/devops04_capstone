package com.azeroth.scoreboard.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class MatchDTO {
  private Integer matchId;
  private String matchDate;
  private LocalDate matchDate2;
  private String leagueName;
  private String seasonName;
  private Integer week;
  private String hostName;
  private String hostLogo;
  private Integer hostScore;
  private String guestName;
  private String guestLogo;
  private Integer guestScore;
  private String status;
}