package com.aquascore.api.controllers;

import com.aquascore.api.models.Team;
import com.aquascore.api.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/teams/")
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("/")
    public List<Team> getAll(HttpServletRequest req) {
        return teamService.getAll();
    }

    @PostMapping("/")
    public Team create(@RequestBody Team newTeam) {
        return teamService.create(newTeam);
    }

    @PatchMapping("/{team_id}")
    public Team edit(@RequestBody Team newTeam, @PathVariable("team_id") long teamId) {
        return teamService.edit(newTeam, teamId);
    }

    @DeleteMapping("/{team_id}")
    public void remove(@PathVariable("team_id") long teamId) {
        teamService.remove(teamId);
    }

    @PatchMapping("/{team_id}/drivers/{driver_id}")
    public Team addDriver(@PathVariable("team_id") long teamId, @PathVariable("driver_id") long driverId) {
        return teamService.addDriver(teamId, driverId);
    }

    @DeleteMapping("/{team_id}/drivers/{driver_id}")
    public Team removeDriver(@PathVariable("team_id") long teamId, @PathVariable("driver_id") long driverId) {
        return teamService.removeDriver(teamId, driverId);
    }
}