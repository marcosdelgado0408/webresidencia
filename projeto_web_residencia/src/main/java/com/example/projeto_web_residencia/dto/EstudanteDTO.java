package com.example.projeto_web_residencia.dto;

import com.example.projeto_web_residencia.model.Diretor;
import com.example.projeto_web_residencia.model.Estudante;
import com.example.projeto_web_residencia.model.Materia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudanteDTO {
    private long matricula;

    private String nome;
    private Date dataNascimento;
    private String endereco;
    private List<Materia> materiasCadastradas;
    private int ano;
    private String nivelEnsino;


    public EstudanteDTO(Estudante estudante) {
        this.matricula = estudante.getMatricula();
        this.nome = estudante.getNome();
        this.dataNascimento = estudante.getDataNascimento();
        this.endereco = estudante.getEndereco();
        this.materiasCadastradas = estudante.getMateriasCadastradas();
        this.ano = estudante.getAno();
        this.nivelEnsino = estudante.getNivelEnsino();
    }

    public static List<EstudanteDTO> convert(List<Estudante> estudantes){
        return estudantes.stream().map(EstudanteDTO::new).collect(Collectors.toList());
    }


    // conversão no caso que exista paginacao
    public static Page<EstudanteDTO> convert(Page<Estudante> estudantes){

        List<EstudanteDTO> estudantesDTO = estudantes.stream().map(EstudanteDTO::new).collect(Collectors.toList());

        return new PageImpl<>(estudantesDTO);
    }


}
