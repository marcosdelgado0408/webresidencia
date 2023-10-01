package com.example.projeto_web_residencia.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "materias")
public class Materia implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_materias")
    private long id;

    private String nome;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "materia_estudante", joinColumns = { @JoinColumn(name =
//    "materia_id", referencedColumnName = "id_materias")}, inverseJoinColumns = {
//    @JoinColumn(name = "estudante_id") })
//    private List<Estudante> estudantes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
