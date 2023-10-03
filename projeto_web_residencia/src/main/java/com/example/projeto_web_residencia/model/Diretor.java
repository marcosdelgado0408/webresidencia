package com.example.projeto_web_residencia.model;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.util.Date;



@Entity
@Table(name = "diretores")

@SQLDelete(sql = "UPDATE diretores SET deleted = true WHERE cpf=?")
@Where(clause = "deleted=false")
public class Diretor implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "cpf_diretor")
    private long cpf;


    private String nome;
    private Date dataNascimento;
    private String endereco;
    private boolean deleted = Boolean.FALSE;


    @OneToOne
    @JoinColumn(name="escola_cnpj")
    private Escola escola;

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
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

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
