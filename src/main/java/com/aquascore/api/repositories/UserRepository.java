package com.aquascore.api.repositories;

import com.aquascore.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);

    User findByEmail(String email);

    boolean existsByEmail(String email);
}
