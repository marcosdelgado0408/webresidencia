package com.example.projetodeweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudantes")
public class EscolaController {

    @GetMapping
    public String retornarEstudantes(){
        return "teste";
    }


}
