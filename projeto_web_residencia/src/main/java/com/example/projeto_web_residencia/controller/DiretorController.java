package com.example.projeto_web_residencia.controller;

import com.example.projeto_web_residencia.model.Diretor;
import com.example.projeto_web_residencia.repository.DiretorRepository;
import com.example.projeto_web_residencia.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretor")
public class DiretorController {

    @Autowired
    private DiretorRepository DiretorRepository;

    @Autowired
    DiretorService service;


    @GetMapping
    public List<Diretor> retornarDiretor(){

        return DiretorRepository.findAll();
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<Diretor> findById(@PathVariable long cpf){
        Diretor obj = this.service.findById(cpf);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Diretor adicionarDiretor(@RequestBody Diretor diretor){
        return DiretorRepository.save(diretor);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarDiretor(@RequestBody Diretor diretor){
        DiretorRepository.delete(diretor);
    }

    @PutMapping(value = "/{cpf}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Diretor> update(@PathVariable long cpf, @RequestBody Diretor obj){
        Diretor newObj = service.update(cpf, obj);
        return ResponseEntity.ok().body(newObj);
    }


}