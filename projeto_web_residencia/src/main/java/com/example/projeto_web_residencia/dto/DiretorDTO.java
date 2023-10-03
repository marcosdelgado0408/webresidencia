package com.example.projeto_web_residencia.dto;

import com.example.projeto_web_residencia.model.Diretor;
import com.example.projeto_web_residencia.model.Escola;
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
public class DiretorDTO {

    private long cpf;

    private String nome;
    private Date dataNascimento;
    private String endereco;
    private Escola escola;


    public DiretorDTO(Diretor diretor) {
        this.cpf = diretor.getCpf();
        this.nome = diretor.getNome();
        this.dataNascimento = diretor.getDataNascimento();
        this.endereco = diretor.getEndereco();
        this.escola = diretor.getEscola();
    }

    public static List<DiretorDTO> convert(List<Diretor> diretores){
        return diretores.stream().map(DiretorDTO::new).collect(Collectors.toList());
    }

    public static Page<DiretorDTO> convert(Page<Diretor> diretores){
        List<DiretorDTO> diretoresDTO =  diretores.stream().map(DiretorDTO::new).collect(Collectors.toList());


        return new PageImpl<>(diretoresDTO);
    }





}
