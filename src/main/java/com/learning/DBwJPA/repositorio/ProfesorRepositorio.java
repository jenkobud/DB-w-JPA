package com.learning.DBwJPA.repositorio;

import com.learning.DBwJPA.entity.Profesor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfesorRepositorio extends CrudRepository<Profesor, Long> {
    Profesor findById(long id);
    Profesor findByNombre(String n);
    //Lista trae todo registro que coincida.
    List<Profesor> findAllByNombre(String n);
    List<Profesor> findByNombreContaining(String substring);
    Profesor findByCursosPorProfesor_Nombre(String nombreCurso);
}
