package com.azeroth.scoreboard.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "ranks")
public class Rank extends BaseModel {
  @ManyToOne
  @JoinColumn(name = "league_id", referencedColumnName = "id")
  @JsonIgnore
  private League league;

  @ManyToOne
  @JoinColumn(name = "season_id", referencedColumnName = "id")
  private Season season;  

  @ManyToOne
  @JoinColumn(name = "team_id", referencedColumnName = "id")
  @JsonIgnore
  private Team team;

  private Integer position;
  private Integer played;
  private Integer wins;
  private Integer draws;
  private Integer losses;
  @Column(name = "goals_for")
  private Integer goalsFor;
  @Column(name = "goals_against")
  private Integer goalsAgainst;
  @Column(name = "goals_diff")
  private Integer goalsDiff;
  private Integer points;
  @Column(name = "prev_position")
  private Integer prevPosition;
  @Column(name = "position_change")
  private Integer positionChange;
  @Column(name = "form_results")
  private String formResults;
  @Column(name = "next_opponent")
  private Integer nextOpponent;
}