package com.quetz.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quetz.app.model.Califica;
import com.quetz.app.repository.CalificaRepository;

@Service
public class CalificaServiceJPA implements ICalificaService {

	@Autowired CalificaRepository califRepo;
	
	@Override
	public List<Califica> obtenerTodos() {
		return califRepo.findAll();
	}

	@Override
	public void guardarNuevo(Califica califica) {
		califRepo.save(califica);
	}

	@Override
	public Califica buscarPorId(int id) {
		Optional<Califica> calif = califRepo.findById(id);
		if(calif.isPresent()) {
			return calif.get();
		}
		return null;
	}

	@Override
	public void eliminaPorId(int id) {
		califRepo.deleteById(id);
	}

}
