package com.learning.DBwJPA.repositorio;

import com.learning.DBwJPA.entity.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CursoRepositorio extends CrudRepository<Curso, Long> {

    List<Curso> findByProfesorApellido(String apellidoProfesor);
    List<Curso> findByProfesorApellidoOrdOrderByProfesorApellido(String apellidoProfesor);
}
