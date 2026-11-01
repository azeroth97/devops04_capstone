package com.azeroth.scoreboard.model;

import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "seasons")
public class Season extends BaseModel {
  private String name;
  private String name2;
  private String alias;

  @ManyToMany
  @JoinTable(
    name = "season_teams",
    joinColumns = @JoinColumn(name = "season_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "id")
  )
  @JsonIgnore
  private Set<Team> teams;

  @ManyToMany
  @JoinTable(
    name = "season_leagues",
    joinColumns = @JoinColumn(name = "season_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "league_id", referencedColumnName = "id")
  )
  @JsonIgnore
  private Set<League> leagues;

  @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Match> matches;

  @OneToMany(mappedBy = "season", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Rank> ranks;
}
