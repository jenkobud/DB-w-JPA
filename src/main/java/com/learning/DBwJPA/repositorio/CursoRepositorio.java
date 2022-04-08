package com.learning.DBwJPA.repositorio;

import com.learning.DBwJPA.entity.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepositorio extends CrudRepository<Curso, Long> {

    //Testing errors
    Curso findById(long id);
    List<Curso> findByProfesorApellido(String apellidoProfesor);
    List<Curso> findByProfesor_Id(long idProfesor);
    //List<Curso> findByProfesorApellidoOrderByProfesorApellido(String apellidoProfesor);
}
