package com.aquascore.api.repositories;

import com.aquascore.api.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
