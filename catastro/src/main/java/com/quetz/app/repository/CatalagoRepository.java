package com.quetz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quetz.app.model.Catalogo;

public interface CatalagoRepository extends JpaRepository<Catalogo, Integer> {

	Catalogo findByNombre(String nombre);
}
