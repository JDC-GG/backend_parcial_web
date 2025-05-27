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

import com.example.parcialweb.dto.ContratoDTO;
import com.example.parcialweb.services.ContratoService;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @PostMapping
    public ResponseEntity<ContratoDTO> crear(@RequestBody ContratoDTO dto) {
        return ResponseEntity.ok(contratoService.crear(dto));
    }

    @GetMapping
    public List<ContratoDTO> listar() {
        return contratoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(contratoService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContratoDTO> actualizar(@PathVariable Long id, @RequestBody ContratoDTO dto) {
        return ResponseEntity.ok(contratoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        contratoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
