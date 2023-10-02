package com.example.projeto_web_residencia.controller;

import com.example.projeto_web_residencia.model.Escola;
import com.example.projeto_web_residencia.repository.EscolaRepository;
import com.example.projeto_web_residencia.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escolas")
public class EscolaController {

    @Autowired
    private EscolaRepository escolaRepository;

    @Autowired
    EscolaService service;


    @GetMapping
    public Page<Escola> retornarEscola(Pageable pageable){
        return escolaRepository.findAll(pageable);
    }

    @GetMapping(value = "/{cnpj}")
    public ResponseEntity<Escola> findById(@PathVariable long cnpj){
        Escola obj = this.service.findById(cnpj);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Escola adicionarEscolas(@RequestBody Escola escola){
        return escolaRepository.save(escola);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarEscola(@RequestBody Escola escola){
        escolaRepository.delete(escola);
    }

    @PutMapping(value = "/{cnpj}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Escola> update(@PathVariable long cnpj, @RequestBody Escola obj){
        Escola newObj = service.update(cnpj, obj);
        return ResponseEntity.ok().body(newObj);
    }


}
