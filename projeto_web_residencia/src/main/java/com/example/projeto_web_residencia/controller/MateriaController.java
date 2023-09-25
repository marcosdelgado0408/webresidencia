package com.example.projeto_web_residencia.controller;


import com.example.projeto_web_residencia.model.Materia;
import com.example.projeto_web_residencia.repository.MateriaRepository;
import com.example.projeto_web_residencia.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    MateriaService service;


    @GetMapping
    public List<Materia> retornarMaterias(){

        return materiaRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Materia> findById(@PathVariable long id){
        Materia obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Materia adicionarMaterias(@RequestBody Materia materia){
        return materiaRepository.save(materia);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarMateria(@RequestBody Materia materia){
        materiaRepository.delete(materia);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Materia> update(@PathVariable long id, @RequestBody Materia obj){
        Materia newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }


}
