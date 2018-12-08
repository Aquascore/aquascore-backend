package com.aquascore.api.controllers;

import javax.servlet.http.HttpServletRequest;

import com.aquascore.api.models.PoolTeam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poolteams/")
public class PoolTeamController{

    @PostMapping("/")
    public PoolTeam create(@RequestBody PoolTeam newTeamPool){
        // Maak nieuwe PoolTeam in db
        int aa = 1;
        return new PoolTeam();
    }
}