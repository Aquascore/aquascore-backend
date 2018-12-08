package com.aquascore.api.controllers;

import javax.servlet.http.HttpServletRequest;

import com.aquascore.api.models.PoolTeam;
import com.aquascore.api.services.PoolTeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poolteams/")
public class PoolTeamController{
    
    @Autowired
    private PoolTeamService poolTeamService;

    @PostMapping("/")
    public PoolTeam create(@RequestBody PoolTeam newTeamPool) {
        return poolTeamService.create(newTeamPool);
    }
}