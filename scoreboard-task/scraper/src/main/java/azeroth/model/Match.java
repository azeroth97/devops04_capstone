package azeroth.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Match {
  private String matchSeason;
  private String matchWeek;
  private String matchDate;
  private String hostTeam;
  private String guestTeam;
  private String result;
  private String status;
}
