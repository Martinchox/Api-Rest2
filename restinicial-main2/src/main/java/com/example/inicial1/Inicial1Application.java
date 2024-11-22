package com.example.inicial1;

import com.example.inicial1.entities.*;
import com.example.inicial1.repositories.PersonaRepository;
import com.example.inicial1.services.*;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Inicial1Application {
	private static final Logger logger = LoggerFactory.getLogger(Inicial1Application.class);

	@Autowired
	private PersonaServiceImpl personaServiceImpl;
	@Autowired
	private LocalidadServiceImpl localidadServiceImpl;
	@Autowired
	private LibroServiceImpl libroServiceImpl;
	@Autowired
	private AutorServiceImpl autorServiceImpl;
	@Autowired
	private DomicilioServiceImpl domicilioServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(Inicial1Application.class, args);
		System.out.println("funcionando");
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository) {
		return args -> {
			// Creo un objeto localidad
			Localidad localidad1 = Localidad.builder()
					.denominacion("Mendoza")
					.build();

			// Guardo la localidad primero
			localidadServiceImpl.save(localidad1);

			// Creo un objeto persona
			Persona per1 = Persona.builder()
					.nombre("Martin")
					.apellido("Porollan")
					.build();

			// Creo un objeto domicilio y asigno la localidad
			Domicilio dom1 = Domicilio.builder()
					.calle("Chivilcoy")
					.numero(1808)
					.localidad(localidad1)  // Usar la misma localidad ya guardada
					.build();

			// Asigno el domicilio a la persona
			per1.setDomicilio(dom1);

			// Guardo la persona en la base de datos
			personaRepository.save(per1);

			// Repetir el proceso para la segunda persona
			Persona per2 = Persona.builder()
					.nombre("Lucas")
					.apellido("beta")
					.build();

			Domicilio dom2 = Domicilio.builder()
					.calle("Rodriguez Peña")
					.numero(589)
					.localidad(localidad1)  // Asignar la misma localidad ya guardada
					.build();

			per2.setDomicilio(dom2);
			personaRepository.save(per2);

			// Código adicional para libro y autor
			Libro libro1 = Libro.builder()
					.titulo("El Señor de los Anillos")
					.build();

			Autor autor1 = Autor.builder()
					.nombre("J.R.R. Tolkien")
					.build();

			libroServiceImpl.save(libro1);
			autorServiceImpl.save(autor1);

			/*List<Persona> recuperadas = personaRepository.findAll();
			for (Persona persona : recuperadas) {
				Hibernate.initialize(persona.getLibros());
			}
			System.out.println(recuperadas);
			logger.info("Detalles de la persona: {}", recuperadas);

			Optional<Persona> recuperada = personaRepository.findById(1L);
			System.out.println(recuperada);
			logger.info("Detalles de la persona: {}", recuperada);

			dom1.setCalle("San Martin");
			domicilioServiceImpl.save(dom1);*/
		};
	}
}