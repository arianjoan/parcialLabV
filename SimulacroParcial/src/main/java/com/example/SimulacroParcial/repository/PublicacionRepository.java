package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.entity.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion,Integer> {
}
