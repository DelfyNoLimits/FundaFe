package com.example.effunda.controllers;

import com.example.effunda.models.Persona;
import com.example.effunda.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @PutMapping("/{id}")
    public Persona updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) {
        Persona persona = personaRepository.findById(id).orElse(null);

        if (persona != null) {
            persona.setNombre(personaDetails.getNombre());
            persona.setApellido(personaDetails.getApellido());
            persona.setEdad(personaDetails.getEdad());

            return personaRepository.save(persona);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id) {
        personaRepository.deleteById(id);
    }
}
