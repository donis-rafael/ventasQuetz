package com.quetz.app.service;

import java.util.List;

import com.quetz.app.model.Puesto;

public interface IPuestoService {
	List<Puesto> obtenerTodos();
	void guardarNuevo(Puesto puesto);
	Puesto buscarPorId(int id);
	void eliminarPorId(int id);
	Puesto buscarPorNombre(String nombre);
}
