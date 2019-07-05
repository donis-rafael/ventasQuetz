package com.quetz.app.service;

import java.util.List;

import com.quetz.app.model.Usuario;

public interface IUserService {
	List<Usuario> obtenerTodos();
	void addNuevo(Usuario user);
	Usuario buscarPorId(int id);
	void eliminarPorId(int id);
}
