package com.example.inicial1.repositories;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.entities.Persona;
import org.springframework.stereotype.Repository;


@Repository
public interface AutorRepository extends BaseRepository<Autor, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}