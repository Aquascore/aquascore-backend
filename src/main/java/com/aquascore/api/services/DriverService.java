package com.aquascore.api.services;

import java.util.List;

import com.aquascore.api.models.Driver;
import com.aquascore.api.models.Team;
import com.aquascore.api.repositories.DriverRepository;
import com.aquascore.api.repositories.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Driver getById(long id) {
        return driverRepository.findById(id);
    }

    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    public Driver create(Driver newDriver) {
        driverRepository.save(newDriver);
        return newDriver;
    }

    public Driver edit(Driver newDriver, long driverId) {
        Driver oldDriver = driverRepository.findById(driverId);

        oldDriver.setFirstname(newDriver.getFirstname());
        oldDriver.setLastname(newDriver.getLastname());
        oldDriver.setSalary(newDriver.getSalary());

        if (oldDriver.getTeamid() != newDriver.getTeamid()) {
            Team oldTeam = teamRepository.findById(oldDriver.getTeamid());
            Team newTeam = teamRepository.findById(newDriver.getTeamid());

            oldDriver.setTeamid(newDriver.getTeamid());

            oldTeam.removeMember(oldDriver);
            newTeam.addMember(oldDriver);

            teamRepository.save(oldTeam);
            teamRepository.save(newTeam);
        }

        driverRepository.save(oldDriver);
        return oldDriver;
    }

    public void remove(long driverId) {
        Driver driver = driverRepository.findById(driverId);
        Team currentTeam = teamRepository.findById(driver.getTeamid());
        currentTeam.removeMember(driver);

        teamRepository.save(currentTeam);
        driverRepository.delete(driver);
    }

    public List<Driver> findByName(String query){
        return driverRepository.findAllByFirstnameContainingOrLastnameContaining(query, query);
    }
}