package com.aquascore.api.controllers;

import com.aquascore.api.models.User;
import com.aquascore.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/users/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public User current(HttpServletRequest req) {
        return userService.getCurrentUser(req);
    }

    @PostMapping("/sign-up")
    public User signUp(@Valid @RequestBody User newUser) {
        return userService.signUp(newUser);
    }

    @PostMapping("/sign-in")
    public Map<String, String> signIn(@RequestBody User user) {
        return userService.signIn(user.getEmail(), user.getPassword());
    }
}
