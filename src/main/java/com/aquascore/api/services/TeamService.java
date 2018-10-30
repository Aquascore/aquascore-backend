package com.aquascore.api.services;

import com.aquascore.api.repositories.DriverRepository;
import com.aquascore.api.repositories.TeamRepository;
import com.aquascore.api.models.Team;

import java.util.List;

import com.aquascore.api.models.Driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService{
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private DriverRepository driverRespository;

    public List<Team> getAll(){
        return teamRepository.findAll();
    }

    public Team create(Team newTeam){
        teamRepository.save(newTeam);
        return newTeam;
    }

    public void remove(long teamId){
        Team team = teamRepository.findById(teamId);
        teamRepository.delete(team);
    }

    public Team edit(Team newTeam, long teamId){
        Team oldTeam = teamRepository.findById(teamId);

        oldTeam.setName(newTeam.getName());
        oldTeam.setTeamcol(newTeam.getTeamcol());

        teamRepository.save(oldTeam);
        return oldTeam;
    }

    public Team addDriver(long teamId, long driverId){
        Team team = teamRepository.findById(teamId);
        Driver driver = driverRespository.findById(driverId);

        team.addMember(driver);
        teamRepository.save(team);

        return team;
    }

    public Team removeDriver(long teamId, long driverId){
        Team team = teamRepository.findById(teamId);
        Driver driver = driverRespository.findById(driverId);

        team.removeMember(driver);
        teamRepository.save(team);

        return team;
    }
}