package com.quetz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quetz.app.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}