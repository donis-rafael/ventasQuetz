package com.quetz.app.service;

import java.util.List;

import com.quetz.app.model.Rol;

public interface IRolService {
	List<Rol> obtenerTodos();
	Rol buscarPorNombre(String nombre);
}
