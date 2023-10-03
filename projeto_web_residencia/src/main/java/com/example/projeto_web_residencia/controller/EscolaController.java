package com.example.projeto_web_residencia.controller;

import com.example.projeto_web_residencia.dto.EscolaDTO;
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
    public Page<EscolaDTO> retornarEscola(Pageable pageable){

        Page<Escola> escolas = escolaRepository.findAll(pageable);

        return EscolaDTO.convert(escolas);
    }

    @GetMapping(value = "/{cnpj}")
    public ResponseEntity<EscolaDTO> findById(@PathVariable long cnpj){

        Escola obj = this.service.findById(cnpj);

        return ResponseEntity.ok().body(new EscolaDTO(obj));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EscolaDTO adicionarEscolas(@RequestBody Escola escola){

        escolaRepository.save(escola);

        return new EscolaDTO(escola);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarEscola(@RequestBody Escola escola){
        escolaRepository.delete(escola);
    }

    @PutMapping(value = "/{cnpj}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<EscolaDTO> update(@PathVariable long cnpj, @RequestBody Escola obj){
        Escola newObj = service.update(cnpj, obj);

        EscolaDTO escolaDTO = new EscolaDTO(newObj);

        return ResponseEntity.ok().body(escolaDTO);
    }


}
