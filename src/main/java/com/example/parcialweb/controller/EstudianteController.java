package com.example.parcialweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parcialweb.model.Estudiante;
import com.example.parcialweb.repository.EstudianteRepository;

@RestController
@RequestMapping("/estudiantes")
@CrossOrigin(origins = "http://localhost:4200") // Permite peticiones desde Angular
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // Obtener todos los estudiantes
    @GetMapping
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    // Obtener un estudiante por ID
    @GetMapping("/{id}")
    public Optional<Estudiante> getEstudianteById(@PathVariable Long id) {
        return estudianteRepository.findById(id);
    }

    // Crear un nuevo estudiante
    @PostMapping
    public Estudiante createEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // Actualizar un estudiante existente
    @PutMapping("/{id}")
    public Estudiante updateEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        return estudianteRepository.save(estudiante);
    }

    // Eliminar un estudiante por ID
    @DeleteMapping("/{id}")
    public void deleteEstudiante(@PathVariable Long id) {
        estudianteRepository.deleteById(id);
    }
}
