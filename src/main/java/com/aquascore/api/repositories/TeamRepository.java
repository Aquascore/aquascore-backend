package com.aquascore.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aquascore.api.models.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
    Team findById(long id);
}