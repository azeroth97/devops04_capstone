package com.azeroth.scoreboard.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "matches")
public class Match extends BaseModel {
  @Column(name = "match_week")
  private Integer matchWeek;
  @Column(name = "match_date")
  private String matchDate;
  @Column(name = "match_date2")
  private LocalDate matchDate2;
  private String status;

  @ManyToOne
  @JoinColumn(name = "league_id", referencedColumnName = "id")
  private League league;

  @ManyToOne
  @JoinColumn(name = "season_id", referencedColumnName = "id")
  private Season season;

  @ManyToOne
  @JoinColumn(name = "host_id", referencedColumnName = "id")
  private Team host;

  @Column(name = "host_score")
  private Integer hostScore;

  @ManyToOne
  @JoinColumn(name = "guest_id", referencedColumnName = "id")
  private Team guest;
  
  @Column(name = "guest_score")
  private Integer guestScore;
}
