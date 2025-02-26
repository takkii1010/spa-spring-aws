package com.tiscon11.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tiscon11.question.entity.User;
import com.tiscon11.question.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.findUser(loginRequest.userId(), loginRequest.userPassword());

        if (user != null) {
            return ResponseEntity.ok(new LoginResponse("success", "Login successful"));
        } else {
            return ResponseEntity.badRequest().body(new LoginResponse("error", "Login failed"));
        }
    }

    private record LoginRequest(
        Integer userId,
        String userPassword
    ){}

    private record LoginResponse(
        String status,
        String message
    ){}
}


