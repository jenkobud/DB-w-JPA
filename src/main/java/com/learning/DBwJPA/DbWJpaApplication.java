package com.learning.DBwJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.learning.DBwJPA.entity.Profesor;
import com.learning.DBwJPA.repositorio.ProfesorRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DbWJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(DbWJpaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DbWJpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(ProfesorRepositorio profesorR) {
		return (args) -> {
			// save a few customers
			profesorR.save(new Profesor("Jack", "Bauer", new Date(System.currentTimeMillis()), 1000));
			profesorR.save(new Profesor("Chloe O", "Brian", new Date(System.currentTimeMillis()), 2000));
			profesorR.save(new Profesor("Kim", "Bauer", new Date(System.currentTimeMillis()), 10020));
			profesorR.save(new Profesor("David", "Palmer", new Date(System.currentTimeMillis()), 1220));
			profesorR.save(new Profesor("Michelle", "Dessler", new Date(System.currentTimeMillis()), 20020));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Profesor profesor : profesorR.findAll()) {
				log.info(profesor.toString());
			}
			log.info("");

			// fetch an individual profesor by ID
			Profesor profesor = profesorR.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(profesor.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			//Cambiar a funcion que haya en profesor entity.
			profesorR.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}
