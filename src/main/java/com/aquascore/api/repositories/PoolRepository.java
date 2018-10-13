package com.aquascore.api.repositories;

import com.aquascore.api.models.Pool;
import com.aquascore.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PoolRepository extends JpaRepository<Pool, Long> {
    Pool findById(long id);

    List<Pool> findByUsers(User user);

    List<Pool> findByOwner(User owner);
}
