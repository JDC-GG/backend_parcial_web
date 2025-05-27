package com.example.parcialweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parcialweb.dto.EntidadDTO;
import com.example.parcialweb.services.EntidadService;

@RestController
@RequestMapping("/entidades")
public class EntidadController {

    @Autowired
    private EntidadService entidadService;

    @PostMapping
    public ResponseEntity<EntidadDTO> crear(@RequestBody EntidadDTO dto) {
        return ResponseEntity.ok(entidadService.crear(dto));
    }

    @GetMapping
    public List<EntidadDTO> listar() {
        return entidadService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(entidadService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntidadDTO> actualizar(@PathVariable Long id, @RequestBody EntidadDTO dto) {
        return ResponseEntity.ok(entidadService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        entidadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
