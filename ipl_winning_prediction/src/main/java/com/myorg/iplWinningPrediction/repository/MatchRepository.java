package com.myorg.iplWinningPrediction.repository;

import com.myorg.iplWinningPrediction.model.Matches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Matches,Integer> {
}
