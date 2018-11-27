package com.aquascore.api.repositories;

import com.aquascore.api.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByPoolId(long poolId);
}
