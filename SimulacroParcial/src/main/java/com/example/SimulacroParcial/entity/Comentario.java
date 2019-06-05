package com.example.SimulacroParcial.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comentario {

    @GeneratedValue
    @Id
    private Integer id;
    private String descripcion;
    private LocalDateTime dateTime;
    private String Owner;

    @JsonIgnore
    @JoinColumn(name = "publicacion_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Publicacion publicacion;

}
