package com.example.projeto_web_residencia.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
public class Estudante{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matricula;

    private String nome;
    private Date dataNascimento;
    private String endereco;
    private String password;
    private String login;

    @ManyToMany
    private List<Materia> materiasCadastradas;
    private int ano;
    private String nivelEnsino;

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Materia> getMateriasCadastradas() {
        return materiasCadastradas;
    }

    public void setMateriasCadastradas(List<Materia> materiasCadastradas) {
        this.materiasCadastradas = materiasCadastradas;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getNivelEnsino() {
        return nivelEnsino;
    }

    public void setNivelEnsino(String nivelEnsino) {
        this.nivelEnsino = nivelEnsino;
    }




}
