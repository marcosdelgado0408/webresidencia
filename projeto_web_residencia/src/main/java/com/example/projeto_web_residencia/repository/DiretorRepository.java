package com.example.projeto_web_residencia.repository;
import com.example.projeto_web_residencia.model.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {
}