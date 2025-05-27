package com.example.parcialweb.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identificador;
    private double valor;

    private String nombreContratante;
    private String documentoContratante;

    private String nombreContratantista;
    private String documentoContratantista;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @ManyToOne
    @JoinColumn(name = "entidad_id")
    private Entidad entidad;

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

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }
}
