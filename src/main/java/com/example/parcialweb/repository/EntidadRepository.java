package com.example.parcialweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parcialweb.entity.Entidad;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Long> {
}
