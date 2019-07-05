package com.quetz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quetz.app.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	Categoria findByNombre(String nombre);
}
