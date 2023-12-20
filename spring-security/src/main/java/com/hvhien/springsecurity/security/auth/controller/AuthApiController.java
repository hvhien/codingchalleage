package com.hvhien.springsecurity.security.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apis/v1")
public class AuthApiController {
    @GetMapping("/check")
    public ResponseEntity<String> checkAuthentication(){
        return ResponseEntity.ok("OK");
    }
}
