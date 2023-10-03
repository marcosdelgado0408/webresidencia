package com.example.projeto_web_residencia.dto;


import com.example.projeto_web_residencia.model.Estudante;
import com.example.projeto_web_residencia.model.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaDTO {
    private long id;
    private String nome;

    public MateriaDTO(Materia materia) {
        this.id = materia.getId();
        this.nome = materia.getNome();
    }

    public static List<MateriaDTO> convert(List<Materia> materias){
        return materias.stream().map(MateriaDTO::new).collect(Collectors.toList());
    }

    // conversão no caso que exista paginacao
    public static Page<MateriaDTO> convert(Page<Materia> materias){

        List<MateriaDTO> materiasDTO = materias.stream().map(MateriaDTO::new).collect(Collectors.toList());

        return new PageImpl<>(materiasDTO);
    }

}
