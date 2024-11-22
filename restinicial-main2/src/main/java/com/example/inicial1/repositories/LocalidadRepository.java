package com.example.inicial1.repositories;

import com.example.inicial1.entities.Localidad;
import com.example.inicial1.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}