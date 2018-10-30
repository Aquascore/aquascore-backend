package com.aquascore.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.aquascore.api.models.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{
    Team findById(long id);
}