package com.azeroth.scoreboard.model;

import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "teams")
public class Team extends BaseModel {
  private String name;
  private String logo;
  private String stadium;

  @ManyToOne
  @JoinColumn(name = "league_id", referencedColumnName = "id")
  @JsonIgnore
  private League league;

  @ManyToMany(mappedBy = "teams", cascade = CascadeType.ALL)
  @JsonIgnore
  private Set<Season> seasons;

  @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Match> hostMatches;

  @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Match> guestMatches;

  @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Rank> ranks;
}
