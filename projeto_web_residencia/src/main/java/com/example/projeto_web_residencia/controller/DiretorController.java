package com.example.projeto_web_residencia.controller;

import com.example.projeto_web_residencia.dto.DiretorDTO;
import com.example.projeto_web_residencia.dto.EstudanteDTO;
import com.example.projeto_web_residencia.model.Diretor;
import com.example.projeto_web_residencia.repository.DiretorRepository;
import com.example.projeto_web_residencia.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diretor")
public class DiretorController {

    @Autowired
    private DiretorRepository diretorRepository;

    @Autowired
    DiretorService service;


    @GetMapping
    public Page<DiretorDTO> retornarDiretor(Pageable pageable){

        Page<Diretor> diretores = diretorRepository.findAll(pageable);

        return DiretorDTO.convert(diretores);
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<DiretorDTO> findById(@PathVariable long cpf){

        Diretor obj = this.service.findById(cpf);

        return ResponseEntity.ok().body(new DiretorDTO(obj));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DiretorDTO adicionarDiretor(@RequestBody Diretor diretor){

        diretorRepository.save(diretor);

        return new DiretorDTO(diretor);

    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarDiretor(@RequestBody Diretor diretor){
        diretorRepository.delete(diretor);
    }

    @PutMapping(value = "/{cpf}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<DiretorDTO> update(@PathVariable long cpf, @RequestBody Diretor obj){
        Diretor newObj = service.update(cpf, obj);

        DiretorDTO diretorDTO = new DiretorDTO(newObj);

        return ResponseEntity.ok().body(diretorDTO);
    }


}