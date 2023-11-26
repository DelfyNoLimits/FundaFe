package com.example.effunda.repository;

import com.example.effunda.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    // Puedes añadir métodos personalizados si es necesario
}
