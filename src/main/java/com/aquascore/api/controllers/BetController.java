package com.aquascore.api.controllers;

import com.aquascore.api.models.Bet;
import com.aquascore.api.models.CurrentBet;
import com.aquascore.api.services.CurrentBetService;
import com.aquascore.api.services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/bets/")
public class BetController {
    @Autowired
    CurrentBetService currentBetService;

    @Autowired
    BetService betService;

    @GetMapping("/")
    public List<Bet> getAllBets(HttpServletRequest req) {
        return betService.getAll();
    }
    
    @GetMapping("/{userId}")
    public List<CurrentBet> getAllUserBets(HttpServletRequest req) {
        return currentBetService.getAll();
    }


    @PostMapping("/")
    public CurrentBet create(@RequestBody CurrentBet newBet) {
        return currentBetService.create(newBet);
    }

    @DeleteMapping("/{betId}")
    public void remove(@PathVariable("betId") long betId) {
        currentBetService.remove(betId);
    }
}