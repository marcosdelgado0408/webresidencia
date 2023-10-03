package com.example.projeto_web_residencia.controller;

import com.example.projeto_web_residencia.dto.EstudanteDTO;
import com.example.projeto_web_residencia.model.Estudante;
import com.example.projeto_web_residencia.repository.EstudanteRepository;
import com.example.projeto_web_residencia.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
    public Page<EstudanteDTO> retornarEstudantes(Pageable pageable){

        Page<Estudante> estudantes = estudanteRepository.findAll(pageable);

        return EstudanteDTO.convert(estudantes);
    }

    @GetMapping(value = "/{matricula}")
    public ResponseEntity<EstudanteDTO> findById(@PathVariable long matricula){

        Estudante obj = this.service.findById(matricula);

        return ResponseEntity.ok().body(new EstudanteDTO(obj));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstudanteDTO adicionarEstudantes(@RequestBody Estudante estudante){

        estudanteRepository.save(estudante);

        return new EstudanteDTO(estudante);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarEstudante(@RequestBody Estudante estudante){
         estudanteRepository.delete(estudante);
    }

    @PutMapping(value = "/{matricula}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<EstudanteDTO> update(@PathVariable long matricula, @RequestBody Estudante estudante){
        Estudante newObj = service.update(matricula, estudante);

        EstudanteDTO estudanteDTO = new EstudanteDTO(newObj);

        return ResponseEntity.ok().body(estudanteDTO);
    }


}
