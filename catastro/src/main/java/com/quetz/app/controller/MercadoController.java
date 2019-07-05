package com.quetz.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.quetz.app.model.Mercado;
import com.quetz.app.service.IMercadoService;

@Controller
@RequestMapping("/mercado")
public class MercadoController {

	@Autowired IMercadoService mercaService;
	
	@GetMapping("/index")
	public String index(Model modelo) {
		
		modelo.addAttribute("mercados", mercaService.obtenerTodos());
		return "mercas/index";
	}
	
	@GetMapping("/nuevo")
	public String newMerca(@ModelAttribute Mercado mercado, Model modelo) {
		
		modelo.addAttribute("accion", "Nuevo");
		return "mercas/form";
	}
	
	@PostMapping("/guardar")
	public String saveMerca(@ModelAttribute Mercado mercado, Model modelo, RedirectAttributes attributes, BindingResult result) {
		if(result.hasErrors()) {
			modelo.addAttribute("accion", "Nuevo");
			return "mercas/form";
		}
		
		mercaService.guardarNuevo(mercado);
		
		attributes.addFlashAttribute("mensaje", "El Mercado se Guardó con Exito");
		
		return "redirect:/mercado/index";
	}
	
	@GetMapping("/editar/{id}")
	public String edit(@PathVariable("id") int id, Model modelo) {
		
		modelo.addAttribute("accion", "Editar");
		modelo.addAttribute("mercado", mercaService.buscarPorId(id));
		return "mercas/form";
	}
	
	public String delete(@PathVariable("id") int id, RedirectAttributes attributes) {
		mercaService.eliminarPorId(id);
		
		attributes.addFlashAttribute("mensaje", "El Mercado ha sido Eliminado con Exito");
		
		return "redirect:/mercado/index";
	}
}
