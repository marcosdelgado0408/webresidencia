//package com.example.projeto_web_residencia.controller;
//
//
//import com.example.projeto_web_residencia.dto.Login;
//import com.example.projeto_web_residencia.model.Estudante;
//import com.example.projeto_web_residencia.service.TokenService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AuthController {
//
//    private AuthenticationManager authenticationManager;
//
//
//    private TokenService tokenService;
//
//    @PostMapping("/login")
//    public String login(@RequestBody Login login){
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.login(), login.password());
//
//        Authentication authenticate= this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
//
//        var estudante = (Estudante) authenticate.getPrincipal();
//
//        return tokenService.gerarToken(estudante);
//    }
//
//}
