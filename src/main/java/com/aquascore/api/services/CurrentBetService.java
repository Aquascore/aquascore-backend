package com.aquascore.api.services;

import com.aquascore.api.models.CurrentBet;
import com.aquascore.api.repositories.CurrentBetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentBetService {
    @Autowired
    private CurrentBetRepository currentBetRepository;

    public List<CurrentBet> getAll() {
        return currentBetRepository.findAll();
    }

    public CurrentBet create(CurrentBet newBet) {
        currentBetRepository.save(newBet);
        return newBet;
    }

    public void remove(long betId) {
        CurrentBet bet = currentBetRepository.findById(betId);
        currentBetRepository.delete(bet);
    }
}