package com.example.projeto_web_residencia.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "escolas")
public class Escola implements Serializable {

    @Id
    @GeneratedValue
    @Column (name = "cnpj_escola")
    private long cnpj;



    private String nome;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cpf_diretor")
    private Diretor diretor;

    private String endereco;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estudante> estudantes;


    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
