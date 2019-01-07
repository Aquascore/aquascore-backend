package com.aquascore.api.repositories;

import java.util.List;

import com.aquascore.api.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findById(long Id);
    
    List<Driver> findAllByFirstnameContainingOrLastnameContaining(
        String firstname,
        String lastname);
}