package com.quetz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quetz.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
