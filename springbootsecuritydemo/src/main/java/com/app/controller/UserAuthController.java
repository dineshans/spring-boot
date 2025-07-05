package com.app.controller;

import com.app.entity.UserAuthEntity;
import com.app.service.UserAuthEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    @Autowired
    private UserAuthEntityService userAuthEntityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserAuthEntity userAuthEntity) {
        userAuthEntity.setPassword(passwordEncoder.encode(userAuthEntity.getPassword()));
        userAuthEntityService.save(userAuthEntity);
        return ResponseEntity.ok("User register successfully");
    }
}
