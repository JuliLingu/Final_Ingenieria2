package com.example.demo.controllers;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.entity.Clientes;
import com.example.demo.models.service.ClienteServiceImp;

import jakarta.validation.Valid;

@Controller
public class ClientesController {
	@Autowired
	ClienteServiceImp clienteService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Clientes> lista=clienteService.findAll();
		model.addAttribute("lista",lista);
		model.addAttribute("titulo","Lista de clientes");
		return "listar";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		List<Clientes> lista=clienteService.findAll();
		model.addAttribute("lista",lista);
		model.addAttribute("titulo","Cargar cliente");
		Clientes cl = new Clientes();
		cl.setId(0);
		model.addAttribute("cliente",cl);
		return "form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Clientes cliente,Model model) {
		if((cliente.getNombre()!= null)|| (cliente.getApellido()!= null)||(cliente.getEmail()!= null)) {
			clienteService.save(cliente);
			return "redirect:/listar";
		}else {
			model.addAttribute("error", "Ingresar los datos correctamente");
			return"error";
		}
	}


	@GetMapping("/eliminar/{id}")
	public String eliminar (@PathVariable(value="id")long id,Map<String,Object> model) {
		clienteService.deleteById(id);
		return "redirect:/listar";
		
	}
}
