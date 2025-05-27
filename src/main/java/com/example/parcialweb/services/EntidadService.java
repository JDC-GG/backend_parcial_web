package com.example.parcialweb.services;

import com.example.parcialweb.dto.EntidadDTO;
import com.example.parcialweb.entity.Entidad;
import com.example.parcialweb.repository.EntidadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntidadService {

    @Autowired
    private EntidadRepository entidadRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EntidadDTO crear(EntidadDTO dto) {
        Entidad entidad = modelMapper.map(dto, Entidad.class);
        entidad = entidadRepository.save(entidad);
        return modelMapper.map(entidad, EntidadDTO.class);
    }

    public List<EntidadDTO> listarTodos() {
        return entidadRepository.findAll()
                .stream()
                .map(entidad -> modelMapper.map(entidad, EntidadDTO.class))
                .collect(Collectors.toList());
    }

    public EntidadDTO obtenerPorId(Long id) {
        Entidad entidad = entidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entidad no encontrada con id: " + id));
        return modelMapper.map(entidad, EntidadDTO.class);
    }

    public EntidadDTO actualizar(Long id, EntidadDTO dto) {
        Entidad entidad = entidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entidad no encontrada con id: " + id));
        entidad.setNombre(dto.getNombre());
        entidad.setNit(dto.getNit());
        return modelMapper.map(entidadRepository.save(entidad), EntidadDTO.class);
    }

    public void eliminar(Long id) {
        if (!entidadRepository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar. Entidad no encontrada con id: " + id);
        }
        entidadRepository.deleteById(id);
    }
}
