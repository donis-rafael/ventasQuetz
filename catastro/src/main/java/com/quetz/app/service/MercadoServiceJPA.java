package com.quetz.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quetz.app.model.Mercado;
import com.quetz.app.repository.MercadoRepository;

@Service
public class MercadoServiceJPA implements IMercadoService {
	
	@Autowired MercadoRepository mercaRepo;

	@Override
	public List<Mercado> obtenerTodos() {
		return mercaRepo.findAll();
	}

	@Override
	public void guardarNuevo(Mercado merca) {
		mercaRepo.save(merca);
	}

	@Override
	public Mercado buscarPorId(int id) {
		Optional<Mercado> merca = mercaRepo.findById(id);
		if(merca.isPresent()) {
			return merca.get();
		}
		return null;
	}

	@Override
	public void eliminarPorId(int id) {
		mercaRepo.deleteById(id);
	}

	@Override
	public Mercado buscarPorNombre(String nombre) {
		try {
			return mercaRepo.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}

}
