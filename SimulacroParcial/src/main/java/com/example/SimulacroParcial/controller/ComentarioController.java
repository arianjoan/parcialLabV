package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.entity.Comentario;
import com.example.SimulacroParcial.entity.Usuario;
import com.example.SimulacroParcial.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import com.example.SimulacroParcial.configuration.config;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @GetMapping("")
    public List<Comentario> getAll(){
        return comentarioRepository.findAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        Comentario c = comentarioRepository.findById(id).orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        comentarioRepository.delete(c);
        return new ResponseEntity<String>("El Comentario ha sido borrado exitosamente",HttpStatus.OK);
    }

    @Scheduled(fixedRate = tiempoDeEjecucion) // en configuration -> config.properties
    public void deleteComentario(){
        List<Comentario> comentarios = comentarioRepository.findAll();

        if (!comentarios.isEmpty()) {
            LocalDateTime dateTime = comentarios.get(0).getDateTime();
            Integer id = comentarios.get(0).getId();
            for (Comentario c : comentarios) {
                if (dateTime.equals(c.getDateTime()) < 0) {
                    id = c.getId();
                }
            }
            Comentario comentarioAborrar = comentarioRepository.findById(id).orElse(null);
            comentarioRepository.delete(comentarioAborrar);
        }
    }
}
