package com.example.projeto_web_residencia.controller;

import com.example.projeto_web_residencia.dto.LoginDTO;
import com.example.projeto_web_residencia.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

 private final TokenService tokenService;
 private final AuthenticationManager authenticationManager;

 public AuthController(TokenService tokenService, AuthenticationManager authenticationManager) {
	 this.tokenService = tokenService;
     this.authenticationManager = authenticationManager;
 }

// @PostMapping("/token")
// public String token(Authentication authentication) {
//	 String token = tokenService.generateToken(authentication);
//	 return token;
// }
//



    // NOVO ADICIONADO
    @PostMapping("/token")
    public String token(@RequestBody LoginDTO dto) {

        Authentication authentication = authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(dto.username(), dto.password()));

        return tokenService.generateToken(authentication);
    }




}




