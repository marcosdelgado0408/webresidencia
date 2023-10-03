package com.example.projeto_web_residencia.controller;


import com.example.projeto_web_residencia.dto.MateriaDTO;
import com.example.projeto_web_residencia.model.Materia;
import com.example.projeto_web_residencia.repository.MateriaRepository;
import com.example.projeto_web_residencia.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    MateriaService service;


    @GetMapping
    public Page<MateriaDTO> retornarMaterias(Pageable pageable){

        Page<Materia> materias = materiaRepository.findAll(pageable);

        return MateriaDTO.convert(materias);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MateriaDTO> findById(@PathVariable long id){

        Materia obj = this.service.findById(id);

        return ResponseEntity.ok().body(new MateriaDTO(obj));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MateriaDTO adicionarMaterias(@RequestBody Materia materia){

        materiaRepository.save(materia);

        return new MateriaDTO(materia);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarMateria(@RequestBody Materia materia){
        materiaRepository.delete(materia);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<MateriaDTO> update(@PathVariable long id, @RequestBody Materia obj){
        Materia newObj = service.update(id, obj);

        MateriaDTO materiaDTO = new MateriaDTO(newObj);

        return ResponseEntity.ok().body(materiaDTO);
    }


}
