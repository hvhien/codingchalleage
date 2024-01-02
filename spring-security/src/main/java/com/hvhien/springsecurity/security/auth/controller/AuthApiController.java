package com.hvhien.springsecurity.security.auth.controller;

import com.hvhien.springsecurity.security.auth.jwt.JwtProvider;
import com.hvhien.springsecurity.security.auth.model.CustomeUserDetail;
import com.hvhien.springsecurity.security.auth.model.UserEntity;
import com.hvhien.springsecurity.security.auth.request.LoginRequest;
import com.hvhien.springsecurity.security.auth.request.SignupRequest;
import com.hvhien.springsecurity.security.auth.service.UserService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis/v1")
public class AuthApiController {
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

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
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
        return ResponseEntity.ok(jwtProvider.generateJwt(new CustomeUserDetail(user)));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request){
        userService.createUser(request);
        return ResponseEntity.ok(request.getPassword());
    }

    @GetMapping("/login")
    public ResponseEntity<String> gettoken(){

        return ResponseEntity.ok("loginform");
    }

}
