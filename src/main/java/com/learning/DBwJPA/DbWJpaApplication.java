package com.learning.DBwJPA;

import com.learning.DBwJPA.entity.Curso;
import com.learning.DBwJPA.repositorio.CursoRepositorio;
import com.learning.DBwJPA.repositorio.EstudianteRepositorio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.learning.DBwJPA.entity.Profesor;
import com.learning.DBwJPA.repositorio.ProfesorRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DbWJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(DbWJpaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DbWJpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(ProfesorRepositorio profesorR, CursoRepositorio cursoR, EstudianteRepositorio estudianteR) {
		return (args) -> {
			// save a few customers
			Profesor profesor1 = new Profesor("Jack", "Bauer", new Date(System.currentTimeMillis()), 1000);
			Profesor profesor2 = new Profesor("Chloe O", "Brian", new Date(System.currentTimeMillis()), 2000);
			Profesor profesor3 = new Profesor("Kim", "Bauer", new Date(System.currentTimeMillis()), 10020);

			profesorR.save(profesor1);
			profesorR.save(profesor2);
			profesorR.save(profesor3);
			profesorR.save(new Profesor("David", "Palmer", new Date(System.currentTimeMillis()), 1220));
			profesorR.save(new Profesor("Michelle", "Dessler", new Date(System.currentTimeMillis()), 20020));
			Curso cursoA = new Curso("Algo1","Algo1","Noche",30, profesor1);
			Curso cursoB = new Curso("Algo2","Algo2","Tarde",40, profesor1);
			Curso cursoC = new Curso("Mate","Mate ma","Noche",6,profesor2);
			Curso cursoD= new Curso("Algebra","Algebra","Noche",50,profesor2);
			Curso cursoE = new Curso("Chino","Chino","Tarde",60,profesor2);

			cursoR.save(cursoA);
			cursoR.save(cursoB);
			cursoR.save(cursoC);
			cursoR.save(cursoD);
			cursoR.save(cursoE);

			/**AGUSS

			*/
			//Profesor profesor100=;
			//Mostrar curso por profesor asignado.
			log.info("Customers found with findByProfesor_Id( id ):");
			log.info("-------------------------------");
			/*for(Curso c : cursoR.findByProfesor_Id(1L)){
				log.info(c.toString());
			}*/
			cursoR.findByProfesor_Id(1L).parallelStream().forEach(c -> log.info(c.toString()));
			//Mostrar curso por Apellido profesor .
			log.info("Customers found with findByProfesor_Apellido( apellido ):");
			log.info("-------------------------------");
			/*for(Curso c : cursoR.findByProfesor_Apellido("Brian")){
				log.info(c.toString());
			}*/
			cursoR.findByProfesor_Apellido("Brian").parallelStream().forEach(c -> log.info(c.toString()));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Profesor profesor : profesorR.findAll()) {
				log.info(profesor.toString());
			}
			log.info("-------------------------------");

			// fetch an individual profesor by ID
			Profesor profesor = profesorR.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(profesor.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('i'):");
			log.info("--------------------------------------------");
			//Cambiar a funcion que haya en profesor entity.
			//profesorR.findByNombreContaining("i").parallelStream().forEach(iContain -> log.info(iContain.toString()));
			profesorR.findByNombreContaining("i").forEach(pI -> {log.info(pI.toString());});
			//LISTO c:
			/*for (Profesor iContain : profesorR.findByNombreContaining("i")) {
			  log.info(iContain.toString());
			}*/
			log.info("");
			//Mostrar Profesor que da tal curso.
			log.info("-------------------------------");
			log.info("Mostrar Profesor que da tal curso. with findByProfesor_Apellido( apellido ):");
			Profesor prof = profesorR.findByCursosPorProfesor_Nombre("Algo1");
			log.info(prof.toString());
			log.info("-------------------------------");
		};
	}
}
