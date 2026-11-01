package com.azeroth.scoreboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.azeroth.scoreboard.model.Match;

public interface MatchRepository extends JpaRepository<Match, Integer>, MatchRepositoryCustom {}
