package com.aquascore.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aquascore.api.models.Bet;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long>{
    Bet findById(long id);
}