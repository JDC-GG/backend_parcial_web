package com.example.parcialweb.services;

import com.example.parcialweb.dto.ContratoDTO;
import com.example.parcialweb.entity.Contrato;
import com.example.parcialweb.entity.Entidad;
import com.example.parcialweb.repository.ContratoRepository;
import com.example.parcialweb.repository.EntidadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private EntidadRepository entidadRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ContratoDTO crear(ContratoDTO dto) {
        Contrato contrato = modelMapper.map(dto, Contrato.class);

        Entidad entidad = entidadRepository.findById(dto.getEntidadId())
                .orElseThrow(() -> new RuntimeException("Entidad no encontrada con id: " + dto.getEntidadId()));

        contrato.setEntidad(entidad);
        contrato = contratoRepository.save(contrato);
        return modelMapper.map(contrato, ContratoDTO.class);
    }

    public List<ContratoDTO> listarTodos() {
        return contratoRepository.findAll()
                .stream()
                .map(contrato -> modelMapper.map(contrato, ContratoDTO.class))
                .collect(Collectors.toList());
    }

    public ContratoDTO obtenerPorId(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado con id: " + id));
        return modelMapper.map(contrato, ContratoDTO.class);
    }

    public ContratoDTO actualizar(Long id, ContratoDTO dto) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado con id: " + id));

        contrato.setIdentificador(dto.getIdentificador());
        contrato.setValor(dto.getValor());
        contrato.setNombreContratante(dto.getNombreContratante());
        contrato.setDocumentoContratante(dto.getDocumentoContratante());
        contrato.setNombreContratantista(dto.getNombreContratantista());
        contrato.setDocumentoContratantista(dto.getDocumentoContratantista());
        contrato.setFechaFinal(dto.getFechaFinal());

        if (!contrato.getEntidad().getId().equals(dto.getEntidadId())) {
            Entidad entidad = entidadRepository.findById(dto.getEntidadId())
                    .orElseThrow(() -> new RuntimeException("Entidad no encontrada con id: " + dto.getEntidadId()));
            contrato.setEntidad(entidad);
        }

        contrato = contratoRepository.save(contrato);
        return modelMapper.map(contrato, ContratoDTO.class);
    }

    public void eliminar(Long id) {
        if (!contratoRepository.existsById(id)) {
            throw new RuntimeException("Contrato no encontrado con id: " + id);
        }
        contratoRepository.deleteById(id);
    }
}
