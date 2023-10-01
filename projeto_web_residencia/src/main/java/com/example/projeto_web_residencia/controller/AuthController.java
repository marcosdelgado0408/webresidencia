package com.example.projeto_web_residencia.controller;


import com.example.projeto_web_residencia.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.projeto_web_residencia.dto.LoginDTO;

@RestController
public class AuthController {

    private final TokenService service;
    private final AuthenticationManager authenticationManager;

    public AuthController(TokenService service, AuthenticationManager authenticationManager) {
        this.service = service;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/token")
    public String getToken(@RequestBody LoginDTO loginDTO){

        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password())
                );
        String token = service.generateToken(authentication);
        return token;
    }
}
