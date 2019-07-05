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

import com.quetz.app.model.Rol;
import com.quetz.app.model.Usuario;
import com.quetz.app.service.IRolService;
import com.quetz.app.service.IUserService;

@Controller
@RequestMapping("/usuario")
public class UserController {
	
	@Autowired IUserService userService;
	
	@Autowired IRolService rolService;

	@GetMapping("/index")
	public String index(Model modelo) {
		
		modelo.addAttribute("usuarios", userService.obtenerTodos());
		return "users/index";
	}
	
	@GetMapping("/nuevo")
	public String newUser(@ModelAttribute Usuario usuario, Model modelo) {

		modelo.addAttribute("accion", "Nuevo");
		return "users/form";
	}
	
	@PostMapping("/guardar")
	public String save(Model modelo, @ModelAttribute Usuario usuario, BindingResult result, RedirectAttributes attributes, @RequestParam("rolUsu") String rol) {
		if(result.hasErrors()) {
			modelo.addAttribute("accion", "Nuevo");
			return "users/form";
		}
		
		usuario.setRol(rolService.buscarPorNombre(rol));
		userService.addNuevo(usuario);
		
		attributes.addFlashAttribute("mensaje", "El Usuario se Guardó con Exito");
		
		return "redirect:/usuario/index";
	}
	
	@GetMapping("/editar/{id}")
	public String edit(@PathVariable("id") int id, Model modelo) {
		Usuario usu = userService.buscarPorId(id);
		modelo.addAttribute("rolAsignado", usu.getRol());
		modelo.addAttribute("usuario", usu);
		modelo.addAttribute("accion", "Editar");
		
		return "users/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable("id") int id, RedirectAttributes attributes) {
		userService.eliminarPorId(id);
		
		attributes.addFlashAttribute("mensaje", "El Usuario ha sido Eliminado con Exito");		
		
		return "redirect:/usuario/index";
	}
	
	@ModelAttribute("roles")
	public List<Rol> roles() {
		return rolService.obtenerTodos();
	}
}
