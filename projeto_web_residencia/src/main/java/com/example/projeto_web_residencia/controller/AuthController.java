package com.example.projeto_web_residencia.controller;

import com.example.projeto_web_residencia.service.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

 private final TokenService tokenService;

 public AuthController(TokenService tokenService) {
	 this.tokenService = tokenService;
	 }

 @PostMapping("/token")
 public String token(Authentication authentication) {
	 String token = tokenService.generateToken(authentication);
	 return token;
 }
}

//
//}
