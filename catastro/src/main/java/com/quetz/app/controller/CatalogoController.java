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

import com.quetz.app.model.Catalogo;
import com.quetz.app.model.Puesto;
import com.quetz.app.service.ICatalogoService;
import com.quetz.app.service.IPuestoService;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {

	@Autowired ICatalogoService cataService;
	
	@Autowired IPuestoService puestoService;
	
	@GetMapping("/index")
	public String index(Model modelo) {
		
		modelo.addAttribute("catalogos", cataService.obtenerTodos());
		return "catas/index";
	}
	
	@GetMapping("/nuevo")
	public String newCata(Model modelo, @ModelAttribute Catalogo catalogo) {
		
		modelo.addAttribute("accion", "Nuevo");
		return "catas/form";
	}
	
	@PostMapping("/guardar")
	public String save(Model modelo, @ModelAttribute Catalogo catalogo, BindingResult result, RedirectAttributes attributes, @RequestParam("puestoCat") String puesto) {
		if(result.hasErrors()) {
			modelo.addAttribute("accion", "Nuevo");
			return "catas/form";
		}
		
		catalogo.setPuesto(puestoService.buscarPorNombre(puesto));
		
		cataService.agregarNuevo(catalogo);
		
		attributes.addFlashAttribute("mensaje", "Catalogo agregado con Exito");
		
		return "redirect:/catalogo/index";
	}
	
	@GetMapping("/editar/{id}")
	public String edit(Model modelo, @PathVariable("id") int id) {
		
		Catalogo cata = cataService.buscarPorId(id);
		
		modelo.addAttribute("accion", "Editar");
		modelo.addAttribute("catalogo", cata);
		modelo.addAttribute("puestAsignado", cata.getPuesto());
		return "catas/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable("id") int id, RedirectAttributes attributes) {
		cataService.eliminarPorId(id);
		
		attributes.addFlashAttribute("mensaje", "El Catálogo se ha Eliminado Exitosamente");
		
		return "redirect:/catalogo/index";
	}
	
	@ModelAttribute("puestos")
	public List<Puesto> puestos(){
		return puestoService.obtenerTodos();
	}
}
