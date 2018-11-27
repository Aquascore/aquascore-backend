package com.aquascore.api.services;

import com.aquascore.api.models.Score;
import com.aquascore.api.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(long poolId) {
        return scoreRepository.findByPoolId(poolId);
    }
}
