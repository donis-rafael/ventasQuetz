package com.quetz.app.service;

import java.util.List;

import com.quetz.app.model.Categoria;

public interface ICategoriaService {
	List<Categoria> obtenerTodas();
	void guardarNueva(Categoria cate);
	Categoria buscarPorId(int id);
	void eliminarPorId(int id);
	Categoria buscarPorNombre(String nombre);
}
