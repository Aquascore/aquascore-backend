package com.aquascore.api.services;

import com.aquascore.api.models.Bet;
import com.aquascore.api.repositories.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetService {
    @Autowired
    private BetRepository betRepository;

    public List<Bet> getAll() {
        return betRepository.findAll();
    }

    public Bet create(Bet newBet) {
        betRepository.save(newBet);
        return newBet;
    }

    public void remove(long betId) {
        Bet bet = betRepository.findById(betId);
        betRepository.delete(bet);
    }
}