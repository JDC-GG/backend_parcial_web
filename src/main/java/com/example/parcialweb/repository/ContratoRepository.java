package com.example.parcialweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parcialweb.entity.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
