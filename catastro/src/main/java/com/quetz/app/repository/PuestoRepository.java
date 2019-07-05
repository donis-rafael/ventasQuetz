package com.quetz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quetz.app.model.Puesto;

public interface PuestoRepository extends JpaRepository<Puesto, Integer> {

	Puesto findByNombre(String nombre);
}
