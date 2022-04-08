package com.learning.DBwJPA.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre, apellido;
    private Date fecha_nacimiento;
    private float salario;
    @OneToMany(mappedBy = "profesor") // mappedBy tiene que ser igual a foreign en la otra tabla
    protected List<Curso> cursosPorProfesor;


    protected Profesor() {}

    public Profesor(Long id, String nombre, String apellido, Date fecha_nacimiento, float salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.salario = salario;
    }

    public Profesor(String nombre, String apellido, Date fecha_nacimiento, float salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", salario=" + salario +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
