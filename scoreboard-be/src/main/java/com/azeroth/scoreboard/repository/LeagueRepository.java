package com.azeroth.scoreboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.azeroth.scoreboard.model.League;

public interface LeagueRepository extends JpaRepository<League, Integer> {}
