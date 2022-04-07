package com.learning.DBwJPA.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.zip.DataFormatException;

@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long numero;
    protected Date fecha_hora;

    //Primer parte tabla en la que estoy, segundo a la de referencia
    @OneToOne
    protected Estudiante estudiante;
    @OneToOne
    protected Curso curso;
}
