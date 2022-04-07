package com.learning.DBwJPA.repositorio;

import com.learning.DBwJPA.entity.Estudiante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstudianteRepositorio extends CrudRepository<Estudiante, Long> {
    List<Estudiante> findAllByCarreraOrderByApellido(String carrera);
}
