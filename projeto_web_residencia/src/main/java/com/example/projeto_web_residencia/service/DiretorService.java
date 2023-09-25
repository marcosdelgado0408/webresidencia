package com.example.projeto_web_residencia.service;

import com.example.projeto_web_residencia.model.Diretor;
import com.example.projeto_web_residencia.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.ObjectNotFoundException;
import java.util.Optional;


@Service
public class DiretorService {

    @Autowired
    private DiretorRepository DiretorRepository;


    public Diretor findById(long cpf){
        Optional<Diretor> obj = DiretorRepository.findById(cpf);

        try {
            return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id" + cpf + ", Tipo: " + Diretor.class.getName()));
        }
        catch (ObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public Diretor update(long cpf, Diretor obj) {
        Diretor newObj = findById(cpf);

        newObj.setNome(obj.getNome());
        newObj.setDataNascimento(obj.getDataNascimento());
        newObj.setEndereco(obj.getEndereco());
        newObj.setEscola(obj.getEscola());


        return DiretorRepository.save(newObj);
    }
}
