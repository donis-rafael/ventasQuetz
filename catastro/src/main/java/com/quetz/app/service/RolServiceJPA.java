package com.quetz.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quetz.app.model.Rol;
import com.quetz.app.repository.RolRepository;

@Service
public class RolServiceJPA implements IRolService {

	@Autowired
	RolRepository rolRepo;

	@Override
	public List<Rol> obtenerTodos() {
		return rolRepo.findAll();
	}

	@Override
	public Rol buscarPorNombre(String nombre) {
		for (Rol rol : obtenerTodos()) {
			if (rol.getNombre().equals(nombre)) {
				return rol;
			}
		}
		return null;
	}

}
