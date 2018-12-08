package com.aquascore.api.controllers;

import com.aquascore.api.models.Race;
import com.aquascore.api.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/races/")
public class RaceController {
    @Autowired
    RaceService raceService;

    @GetMapping("/")
    public List<Race> getAll(HttpServletRequest req) {
        return raceService.getAll();
    }

    @PostMapping("/")
    public Race create(@RequestBody Race newRace) {
        return raceService.create(newRace);
    }
}