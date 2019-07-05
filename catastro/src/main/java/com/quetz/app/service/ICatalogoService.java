package com.quetz.app.service;

import java.util.List;

import com.quetz.app.model.Catalogo;

public interface ICatalogoService {
	List<Catalogo> obtenerTodos();
	void agregarNuevo(Catalogo catalog);
	Catalogo buscarPorId(int id);
	void eliminarPorId(int id);
	Catalogo buscarPorNombre(String nombre);
}
