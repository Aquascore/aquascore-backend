package com.aquascore.api.services;

import com.aquascore.api.models.Race;
import com.aquascore.api.repositories.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {
    @Autowired
    private RaceRepository raceRepository;

    public Race getById(long id){
        return raceRepository.findById(id);
    }

    public List<Race> getAll() {
        return raceRepository.findAll();
    }

    public Race create(Race newRace) {
        Race tmpRace = raceRepository.findByDate(newRace.getDate());
        if(tmpRace == null || !tmpRace.getName().equals(newRace.getName())){
            raceRepository.save(newRace);
        }
        return newRace;
    }
}