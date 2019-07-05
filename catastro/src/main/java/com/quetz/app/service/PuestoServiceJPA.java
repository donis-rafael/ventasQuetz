package com.quetz.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quetz.app.model.Puesto;
import com.quetz.app.repository.PuestoRepository;

@Service
public class PuestoServiceJPA implements IPuestoService{

	@Autowired PuestoRepository puestoRepo;
	
	@Override
	public List<Puesto> obtenerTodos() {
		return puestoRepo.findAll();
	}

	@Override
	public void guardarNuevo(Puesto puesto) {
		puestoRepo.save(puesto);
	}

	@Override
	public Puesto buscarPorId(int id) {
		Optional<Puesto> pues = puestoRepo.findById(id);
		if(pues.isPresent()) {
			return pues.get();
		}
		return null;
	}

	@Override
	public void eliminarPorId(int id) {
		puestoRepo.deleteById(id);
	}

	@Override
	public Puesto buscarPorNombre(String nombre) {
		try {
			return puestoRepo.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}

}
