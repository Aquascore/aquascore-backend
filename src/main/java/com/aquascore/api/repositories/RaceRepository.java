package com.aquascore.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aquascore.api.models.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long>{
    Race findById(long id);
}