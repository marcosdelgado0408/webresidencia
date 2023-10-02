package com.example.projeto_web_residencia.controller;

import com.example.projeto_web_residencia.model.Estudante;
import com.example.projeto_web_residencia.repository.EstudanteRepository;
import com.example.projeto_web_residencia.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    EstudanteService service;


    @GetMapping
    public Page<Estudante> retornarEstudantes(Pageable pageable){

        return estudanteRepository.findAll(pageable);
    }

    @GetMapping(value = "/{matricula}")
    public ResponseEntity<Estudante> findById(@PathVariable long matricula){
        Estudante obj = this.service.findById(matricula);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estudante adicionarEstudantes(@RequestBody Estudante estudante){
        return estudanteRepository.save(estudante);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarEstudante(@RequestBody Estudante estudante){
         estudanteRepository.delete(estudante);
    }

    @PutMapping(value = "/{matricula}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Estudante> update(@PathVariable long matricula, @RequestBody Estudante obj){
        Estudante newObj = service.update(matricula, obj);
        return ResponseEntity.ok().body(newObj);
    }


}
