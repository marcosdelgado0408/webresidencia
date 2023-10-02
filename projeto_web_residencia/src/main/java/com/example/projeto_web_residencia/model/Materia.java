package com.example.projeto_web_residencia.model;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;

@Entity
@Table(name = "materias")

@SQLDelete(sql = "UPDATE materias SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Materia implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_materias")
    private long id;

    private String nome;
    private boolean deleted = Boolean.FALSE;


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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
