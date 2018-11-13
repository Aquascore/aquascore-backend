package com.aquascore.api.services;

import java.util.List;

import com.aquascore.api.models.Driver;
import com.aquascore.api.repositories.DriverRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService{
    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAll(){
        return driverRepository.findAll();
    }

    public Driver create(Driver newDriver){
        driverRepository.save(newDriver);
        return newDriver;
    }

    public Driver edit(Driver newDriver, long driverId){
        Driver oldDriver = driverRepository.findById(driverId);

        oldDriver.setFirstname(newDriver.getFirstname());
        oldDriver.setLastname(newDriver.getLastname());
        oldDriver.setSalary(newDriver.getSalary());
        oldDriver.setTeamid(newDriver.getTeamid());

        driverRepository.save(oldDriver);
        return oldDriver;
    }

    public void remove(long driverId){
        Driver driver = driverRepository.findById(driverId);
        driverRepository.delete(driver);
    }
}