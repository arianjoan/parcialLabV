package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Integer> {
}
