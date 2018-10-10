package com.aquascore.api.controllers;

import com.aquascore.api.models.User;
import com.aquascore.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public @ResponseBody
    Iterable<User> home() {
        return repository.findAll();
    }

    @GetMapping("/{email}")
    public @ResponseBody
    User home(@PathVariable String email) {
        return repository.findByEmail(email);
    }

    @PostMapping("/")
    public @ResponseBody
    User create(@RequestBody User newUser) {
        newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));

        return repository.save(newUser);
    }
}
