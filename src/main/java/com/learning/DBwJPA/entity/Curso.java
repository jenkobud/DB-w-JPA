package com.learning.DBwJPA.entity;

import javax.persistence.*;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    protected String nombre, descripicion, turno;
    protected Integer cupo;
    //Mapea y toma a profesor como "foreign key".
    @ManyToOne
    protected Profesor profesor;
}
