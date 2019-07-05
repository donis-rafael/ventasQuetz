package com.quetz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quetz.app.model.Mercado;

public interface MercadoRepository extends JpaRepository<Mercado, Integer> {
	
	Mercado findByNombre(String nombre);
}
