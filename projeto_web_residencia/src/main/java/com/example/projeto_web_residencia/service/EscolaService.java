package com.example.projeto_web_residencia.service;


import com.example.projeto_web_residencia.model.Escola;
import com.example.projeto_web_residencia.model.Estudante;
import com.example.projeto_web_residencia.repository.EscolaRepository;
import com.example.projeto_web_residencia.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.ObjectNotFoundException;
import java.util.Optional;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;


    public Escola findById(long cnpj){
        Optional<Escola> obj = escolaRepository.findById(cnpj);

        try {
            return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id" + cnpj + ", Tipo: " + Escola.class.getName()));
        }
        catch (ObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public Escola update(long cnpj, Escola obj) {
        Escola newObj = findById(cnpj);

        newObj.setNome(obj.getNome());
        newObj.setDiretor(obj.getDiretor());
        newObj.setEndereco(obj.getEndereco());


        return escolaRepository.save(newObj);
    }
}
