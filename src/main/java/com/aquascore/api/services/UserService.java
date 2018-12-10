package com.aquascore.api.services;

import com.aquascore.api.models.Role;
import com.aquascore.api.models.User;
import com.aquascore.api.repositories.UserRepository;
import com.aquascore.api.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Map<String, String> signIn(String email, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

            String token = jwtTokenProvider.createToken(email, userRepository.findByEmail(email).getRoles());
            return Collections.singletonMap("token", token);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid username/password supplied");
        }
    }


    public User signUp(User newUser) {
        if (!userRepository.existsByEmail(newUser.getEmail())) {
            newUser.setRoles(new ArrayList<>(Arrays.asList(Role.ROLE_USER)));
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

            userRepository.save(newUser);

            return newUser;
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "E-mail is already in use");
        }
    }

    public User getCurrentUser(HttpServletRequest req) {
        return userRepository.findByEmail(jwtTokenProvider.getEmail(jwtTokenProvider.resolveToken(req)));
    }

    public User findById(long id) {
        return userRepository.findById(id);
    }

    public User findByEmail(String query) {
        return userRepository.findByEmail(query);
    }
}
