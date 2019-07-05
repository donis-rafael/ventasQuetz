package com.quetz.app.service;

import java.util.List;

import com.quetz.app.model.Mercado;

public interface IMercadoService {
	List<Mercado> obtenerTodos();
	void guardarNuevo(Mercado merca);
	Mercado buscarPorId(int id);
	void eliminarPorId(int id);
	Mercado buscarPorNombre(String nombre);
}
