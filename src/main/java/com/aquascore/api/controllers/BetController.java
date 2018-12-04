package com.aquascore.api.controllers;

import com.aquascore.api.models.Bet;
import com.aquascore.api.services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/bets/")
public class BetController {
    @Autowired
    BetService betService;

    @GetMapping("/")
    public List<Bet> getAll(HttpServletRequest req) {
        return betService.getAll();
    }

    @PostMapping("/")
    public Bet create(@RequestBody Bet newBet) {
        return betService.create(newBet);
    }

    @DeleteMapping("/{betId}")
    public void remove(@PathVariable("betId") long betId) {
        betService.remove(betId);
    }
}