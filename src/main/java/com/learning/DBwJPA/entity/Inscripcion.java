package com.learning.DBwJPA.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="inscripcion")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected Date fecha_hora;

    //Primer parte tabla en la que estoy, segundo a la de referencia
    @OneToOne
    protected Estudiante estudiante;
    @OneToOne
    protected Curso curso;

    protected Inscripcion () {}

    public Inscripcion(Long id, Date fecha_hora, Estudiante estudiante, Curso curso) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public Inscripcion(Date fecha_hora, Estudiante estudiante, Curso curso) {
        this.fecha_hora = fecha_hora;
        this.estudiante = estudiante;
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numero=" + id +
                ", fecha_hora=" + fecha_hora +
                ", estudiante=" + estudiante +
                ", curso=" + curso +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
