package com.aquascore.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aquascore.api.models.PoolTeam;

@Repository
public interface PoolTeamRepository extends JpaRepository<PoolTeam, Long>{
    PoolTeam findById(long id);
}