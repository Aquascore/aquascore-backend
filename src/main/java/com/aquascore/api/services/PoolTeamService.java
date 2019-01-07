package com.aquascore.api.services;

import com.aquascore.api.models.PoolTeam;
import com.aquascore.api.repositories.PoolTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoolTeamService {
    @Autowired
    private PoolTeamRepository poolTeamRepository;


    public PoolTeam getById(long id){
        return poolTeamRepository.findById(id);
    }

    public List<PoolTeam> getAll() {
        return poolTeamRepository.findAll();
    }

    public PoolTeam create(PoolTeam newTeamPool) {
        poolTeamRepository.save(newTeamPool);
        return newTeamPool;
    }
}