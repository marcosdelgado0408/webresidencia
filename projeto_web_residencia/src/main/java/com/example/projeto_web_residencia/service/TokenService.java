//package com.example.projeto_web_residencia.service;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.example.projeto_web_residencia.model.Estudante;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//
//@Service
//public class TokenService {
//    public String gerarToken(Estudante estudante){
//        return JWT.create()
//                .withIssuer("produtos")
//                .withSubject(estudante.getUsername())
//                .withClaim("id", estudante.getMatricula())
//                .withExpiresAt(LocalDateTime.now()
//                        .plusMinutes(10)
//                        .toInstant(ZoneOffset.of("-03:00"))
//                ).sign(Algorithm.HMAC256("secreta"));
//    }
//
//}
