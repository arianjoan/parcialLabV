package com.example.SimulacroParcial.controller;


import com.example.SimulacroParcial.entity.Publicacion;
import com.example.SimulacroParcial.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    @Autowired
    PublicacionRepository publicacionRepository;

    @GetMapping("")
    public List<Publicacion> getAll(){
        return publicacionRepository.findAll();
    }

    @PostMapping("/{id}")
    public void addComentario(@PathVariable Integer id,@RequestBody Publicacion comentario){
        Publicacion p = publicacionRepository.findById(id).orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        p.getComentarios().add(comentario);
        comentario.setPublicacion(p);
        publicacionRepository.save(p);
    }



}
