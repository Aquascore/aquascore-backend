package com.aquascore.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aquascore.api.models.CurrentBet;

@Repository
public interface CurrentBetRepository extends JpaRepository<CurrentBet, Long>{
    CurrentBet findById(long id);
}