package com.quetz.app.service;

import java.util.List;

import com.quetz.app.model.Califica;

public interface ICalificaService {
	List<Califica> obtenerTodos();
	void guardarNuevo(Califica califica);
	Califica buscarPorId(int id);
	void eliminaPorId(int id);
}
