package com.learning.DBwJPA.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre, Apellido;
    private Date fecha_nacimiento;
    private float salario;

    protected Profesor() {}

    public Profesor(Long id, String nombre, String apellido, Date fecha_nacimiento, float salario) {
        this.id = id;
        this.nombre = nombre;
        Apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.salario = salario;
    }

    public Profesor(String nombre, String apellido, Date fecha_nacimiento, float salario) {
        this.nombre = nombre;
        Apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
