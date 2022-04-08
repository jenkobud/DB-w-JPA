package com.learning.DBwJPA.repositorio;

import com.learning.DBwJPA.entity.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepositorio extends CrudRepository<Curso, Long> {

    //Testing errors
    Curso findById(long id);
    List<Curso> findByProfesorApellido(String apellidoProfesor); // no testeado.
    List<Curso> findByProfesor_Id(long idProfesor);
    List<Curso> findByProfesor_Apellido(String apellidoProfesor);
    //List<Curso> findByProfesorApellidoOrderByProfesorApellido(String apellidoProfesor);
}
