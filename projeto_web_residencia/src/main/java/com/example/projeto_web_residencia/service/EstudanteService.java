package com.example.projeto_web_residencia.service;

import com.example.projeto_web_residencia.model.Estudante;
import com.example.projeto_web_residencia.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.ObjectNotFoundException;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;


    public Estudante findById(long matricula){
        Optional<Estudante> obj = estudanteRepository.findById(matricula);

        try {
            return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id" + matricula + ", Tipo: " + Estudante.class.getName()));
        }
        catch (ObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public Estudante update(long matricula, Estudante obj) {
        Estudante newObj = findById(matricula);

        newObj.setNome(obj.getNome());
        newObj.setDataNascimento(obj.getDataNascimento());
        newObj.setEndereco(obj.getEndereco());
        newObj.setMateriasCadastradas(obj.getMateriasCadastradas());
        newObj.setAno(obj.getAno());
        newObj.setNivelEnsino(obj.getNivelEnsino());

        return estudanteRepository.save(newObj);
    }
}
