package com.example.projeto_web_residencia.dto;

import com.example.projeto_web_residencia.model.Diretor;
import com.example.projeto_web_residencia.model.Escola;
import com.example.projeto_web_residencia.model.Estudante;
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
public class EscolaDTO {
    private long cnpj;

    private String nome;
    private Diretor diretor;

    private String endereco;
    private List<Estudante> estudantes;

    public EscolaDTO(Escola escola) {
        this.cnpj = escola.getCnpj();
        this.nome = escola.getNome();
        this.diretor = escola.getDiretor();
        this.endereco = escola.getEndereco();
        this.estudantes = escola.getEstudantes();
    }

    public static List<EscolaDTO> convert(List<Escola> escolas){
        return escolas.stream().map(EscolaDTO::new).collect(Collectors.toList());
    }

    public static Page<EscolaDTO> convert(Page<Escola> escolas){

        List<EscolaDTO> escolasDTO = escolas.stream().map(EscolaDTO::new).collect(Collectors.toList());

        return new PageImpl<>(escolasDTO);
    }



}
