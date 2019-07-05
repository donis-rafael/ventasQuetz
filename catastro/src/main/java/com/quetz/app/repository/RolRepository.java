package com.quetz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quetz.app.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
	
}
