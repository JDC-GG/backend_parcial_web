package com.example.parcialweb.dto;

import java.time.LocalDate;

public class ContratoDTO {

    private Long id;
    private String identificador;
    private double valor;

    private String nombreContratante;
    private String documentoContratante;

    private String nombreContratantista;
    private String documentoContratantista;

    private LocalDate fechaFinal;

    private Long entidadId;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNombreContratante() {
        return nombreContratante;
    }

    public void setNombreContratante(String nombreContratante) {
        this.nombreContratante = nombreContratante;
    }

    public String getDocumentoContratante() {
        return documentoContratante;
    }

    public void setDocumentoContratante(String documentoContratante) {
        this.documentoContratante = documentoContratante;
    }

    public String getNombreContratantista() {
        return nombreContratantista;
    }

    public void setNombreContratantista(String nombreContratantista) {
        this.nombreContratantista = nombreContratantista;
    }

    public String getDocumentoContratantista() {
        return documentoContratantista;
    }

    public void setDocumentoContratantista(String documentoContratantista) {
        this.documentoContratantista = documentoContratantista;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Long getEntidadId() {
        return entidadId;
    }

    public void setEntidadId(Long entidadId) {
        this.entidadId = entidadId;
    }
}
