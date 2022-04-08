package com.learning.DBwJPA.entity;

import javax.persistence.*;

@Entity
@Table(name="curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String nombre, descripicion, turno;
    protected Integer cupo;
    //Mapea y toma a profesor como "foreign key".
    @ManyToOne
    @JoinColumn(name="PROFESOR_TYPE_ID", nullable=true) //name -> lo que quieras
    protected Profesor profesor;

    protected Curso() {}
    public Curso(Long id, String nombre, String descripicion, String turno, Integer cupo, Profesor profesor) {
        this.id = id;
        this.nombre = nombre;
        this.descripicion = descripicion;
        this.turno = turno;
        this.cupo = cupo;
        this.profesor = profesor;
    }

    public Curso(String nombre, String descripicion, String turno, Integer cupo, Profesor profesor) {
        this.nombre = nombre;
        this.descripicion = descripicion;
        this.turno = turno;
        this.cupo = cupo;
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigo=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripicion='" + descripicion + '\'' +
                ", turno='" + turno + '\'' +
                ", cupo=" + cupo +
                ", profesor=" + profesor +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripicion() {
        return descripicion;
    }

    public void setDescripicion(String descripicion) {
        this.descripicion = descripicion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
