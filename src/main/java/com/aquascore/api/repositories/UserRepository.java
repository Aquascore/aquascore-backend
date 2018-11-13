package com.aquascore.api.repositories;

import com.aquascore.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);

    User findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findAllByEmailContainingOrFirstNameContainingOrLastNameContaining(
        String email,
        String firstName,
        String lastName);
}
