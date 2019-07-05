package com.quetz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.quetz.app.model.Califica;
import com.quetz.app.model.Puesto;
import com.quetz.app.service.ICalificaService;
import com.quetz.app.service.IPuestoService;
import com.quetz.app.util.ListaPunteo;
import com.quetz.app.util.Punteo;

@Controller
@RequestMapping("/calificar")
public class CalificaController {
	
	static char band='0';

	@Autowired ICalificaService califService;
	
	@Autowired IPuestoService puestoService;
	
	@GetMapping("/index")
	public String index(Model modelo) {
		modelo.addAttribute("calificaciones", califService.obtenerTodos());
		
		return "califs/index";
	}
	
	@GetMapping("/nuevo/{id}")
	public String newCalif(Model modelo, @ModelAttribute Califica califica, @PathVariable("id") int id) {
		modelo.addAttribute("accion", "Nueva");
		
		if(id==1) {
			band='1';
		}else {
			band='0';
		}
		
		return "califs/form";
	}
	
	@PostMapping("/guardar")
	public String save(Model modelo, @ModelAttribute Califica califica, BindingResult result, RedirectAttributes attributes, @RequestParam("puestCalif") String puesto, @RequestParam("punteoCalif") int punteo) {
		if(result.hasErrors()) {
			modelo.addAttribute("accion", "Nueva");
			return "califs/form";
		}
		
		califica.setPunteo(punteo);
		califica.setPuesto(puestoService.buscarPorNombre(puesto));
		califService.guardarNuevo(califica);
		
		attributes.addFlashAttribute("mensaje", "Calificación guardada con Exito");
		
		if(band=='1') {
			return "redirect:/calificar/index";
		}
		return "califs/gracias";
	}
	
	@ModelAttribute("puestos")
	public List<Puesto> puestos(){
		return puestoService.obtenerTodos();
	}
	
	@ModelAttribute("punteos")
	public List<Punteo> punteos(){
		ListaPunteo lst = new ListaPunteo();
		return lst.getPunteos();
	}
}
