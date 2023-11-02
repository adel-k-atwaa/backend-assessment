package com.example.SystemDesign.web.rest;

import com.example.SystemDesign.Domain.Token;
import com.example.SystemDesign.Service.AuthenticationService;
import com.example.SystemDesign.Service.DTO.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/authentication")
public class AuthenticationResource {

    private final AuthenticationService authenticationService;

    public AuthenticationResource(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(authenticationService.register(userDTO));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Token> authenticate(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(authenticationService.authenticate(userDTO));
    }
}
