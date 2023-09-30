package com.example.projeto_web_residencia.repository;

import com.example.projeto_web_residencia.model.Escola;
import com.example.projeto_web_residencia.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}
