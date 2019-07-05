package com.quetz.app.service;

import java.util.List;

import com.quetz.app.model.Producto;

public interface IProductoService {
	List<Producto> obtenerTodos();
	void guardarNuevo(Producto producto);
	Producto buscarPorId(int id);
	void eliminarPorId(int id);
}