package com.quetz.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quetz.app.model.Catalogo;
import com.quetz.app.repository.CatalagoRepository;

@Service
public class CatalogoServiceJPA implements ICatalogoService {
	
	@Autowired CatalagoRepository cataRepo;

	@Override
	public List<Catalogo> obtenerTodos() {
		return cataRepo.findAll();
	}

	@Override
	public void agregarNuevo(Catalogo catalog) {
		cataRepo.save(catalog);
	}

	@Override
	public Catalogo buscarPorId(int id) {
		Optional<Catalogo> cata = cataRepo.findById(id);
		if(cata.isPresent()) {
			return cata.get();
		}
		return null;
	}

	@Override
	public void eliminarPorId(int id) {
		cataRepo.deleteById(id);
	}

	@Override
	public Catalogo buscarPorNombre(String nombre) {
		try {
			return cataRepo.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}

}
