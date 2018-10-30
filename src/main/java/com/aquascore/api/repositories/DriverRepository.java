package com.aquascore.api.repositories;

import java.util.List;

import com.aquascore.api.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findById(long Id);
    
    List<Driver> findByTeam(long Id);
}