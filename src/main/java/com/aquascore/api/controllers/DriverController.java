package com.aquascore.api.controllers;

import java.util.List;

import com.aquascore.api.models.Driver;
import com.aquascore.api.services.DriverService;
import com.aquascore.api.services.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers/")
public class DriverController{
    @Autowired
    DriverService driverService;

    @Autowired
    TeamService teamService;

    @GetMapping("/")
    public List<Driver> getall(){
        return driverService.getAll();
    }

    @GetMapping("/{driver_id}")
    public Driver getById(@PathVariable("driver_id") long driverId){
        return driverService.getById(driverId);
    }

    @PostMapping("/")
    public Driver create(@RequestBody Driver newDriver){
        Driver temp = driverService.create(newDriver);
        teamService.addDriver(temp.getTeamid(), temp.getId());
        return newDriver;
    }

    @PatchMapping("/{driver_id}")
    public Driver edit(@RequestBody Driver newDriver, @PathVariable("driver_id") long driverId){
        return driverService.edit(newDriver, driverId);
    }

    @DeleteMapping("/{driver_id}")
    public void remove(@PathVariable("driver_id") long driverId){
        driverService.remove(driverId);
    }

    @GetMapping("/find")
    public List<Driver> find(@RequestParam String query){
        return driverService.findByName(query);
    }
}