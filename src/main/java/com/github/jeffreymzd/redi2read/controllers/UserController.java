package com.github.jeffreymzd.redi2read.controllers;

import com.github.jeffreymzd.redi2read.models.User;
import com.github.jeffreymzd.redi2read.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by jeffreymzd on 4/18/21
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public Iterable<User> all(@RequestParam(defaultValue = "") String email) {
        if (email.isEmpty()) {
            return userRepository.findAll();
        } else {
            Optional<User> user = Optional.ofNullable(userRepository.findFirstByEmail(email));
            return user.map(List::of).orElse(Collections.emptyList());
        }
    }
}
