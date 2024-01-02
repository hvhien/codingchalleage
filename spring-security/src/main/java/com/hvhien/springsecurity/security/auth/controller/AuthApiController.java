package com.hvhien.springsecurity.security.auth.controller;

import com.hvhien.springsecurity.security.auth.jwt.JwtProvider;
import com.hvhien.springsecurity.security.auth.model.CustomeUserDetail;
import com.hvhien.springsecurity.security.auth.model.UserEntity;
import com.hvhien.springsecurity.security.auth.request.LoginRequest;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/v1")
public class AuthApiController {
    @Autowired
    private JwtProvider jwtProvider;
    @GetMapping("/check")
    @PermitAll
    public ResponseEntity<String> checkAuthentication(){
        return ResponseEntity.ok("OK1");
    }
    @GetMapping("/random")
    public ResponseEntity<String> checkauthen(){
        return ResponseEntity.ok("protected");
    }
    @PostMapping("/login")
    public ResponseEntity<String> gettoken(@RequestBody LoginRequest loginRequest){
        UserEntity user=new UserEntity();
        user.setId(1L);
        user.setUsername(loginRequest.getUsername());
        user.setPassword(loginRequest.getPassword());
        return ResponseEntity.ok(jwtProvider.generateJwt(new CustomeUserDetail(user)));
    }

    @GetMapping("/login")
    public ResponseEntity<String> gettoken(){

        return ResponseEntity.ok("loginform");
    }

}
