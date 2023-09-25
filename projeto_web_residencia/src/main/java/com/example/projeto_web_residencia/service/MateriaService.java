package com.example.projeto_web_residencia.service;


import com.example.projeto_web_residencia.model.Materia;
import com.example.projeto_web_residencia.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.ObjectNotFoundException;
import java.util.Optional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;


    public Materia findById(long id){
        Optional<Materia> obj = materiaRepository.findById(id);

        try {
            return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id" + id + ", Tipo: " + Materia.class.getName()));
        }
        catch (ObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public Materia update(long id, Materia obj) {
        Materia newObj = findById(id);

        newObj.setNome(obj.getNome());
        newObj.setEstudantes(obj.getEstudantes());

        return materiaRepository.save(newObj);
    }
}
