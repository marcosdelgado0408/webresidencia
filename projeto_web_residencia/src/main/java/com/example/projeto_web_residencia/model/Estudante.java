package com.example.projeto_web_residencia.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "estudantes")
public class Estudante implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "matricula")
    private long matricula;

    private String nome;
    private Date dataNascimento;
    private String endereco;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "materia_estudante", joinColumns = {@JoinColumn(name =
    "estudante_id", referencedColumnName = "matricula")}, inverseJoinColumns = {
    @JoinColumn(name = "materia_id") })
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
