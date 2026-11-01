package com.azeroth.scoreboard.model;

import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "leagues")
public class League extends BaseModel {
  private String name;
  private String alias;
  private String country;

  @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Team> teams;

  @ManyToMany(mappedBy = "leagues", cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<Season> seasons;

  @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Match> matches;

  @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Rank> ranks;
}
