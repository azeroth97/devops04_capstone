package azeroth.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Ranking {
  private String position;
  private String team;
  private String logo;
  private String played;
  private String wins;
  private String draws;
  private String losses;
  private String goalsFor;
  private String goalsAgainst;
  private String points;
}
