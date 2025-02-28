package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.entity.Clientes;
import com.example.demo.models.entity.Turnos;
import com.example.demo.models.service.ClienteServiceImp;
import com.example.demo.models.service.TurnosServiceImp;

@Controller
public class TurnosController {
	 @Autowired
	    private TurnosServiceImp turnosService;

	    @Autowired
	    private ClienteServiceImp clienteService;

	    @GetMapping("/cliente/{clienteId}/turno")
	    public String listarTurnoPorCliente(@PathVariable Long clienteId, Model model) {

	    	Clientes cliente = clienteService.findById(clienteId);


	        if (cliente == null) {
	            model.addAttribute("error", "Cliente no encontrado");
	            return "error"; 
	        }
	        

	        List<Turnos> turnos = turnosService.findByClienteId(clienteId);

	        String titulo = "Turnos de " + cliente.getNombre() + " " + cliente.getApellido();

	        model.addAttribute("turnos", turnos);
	        model.addAttribute("titulo", titulo);
	        

	        return "listarTurnos"; 
	    }
	    
	    @GetMapping("/crearTurno/{clienteId}")
	    public String crearTurno(@PathVariable("clienteId") Long clienteId, Model model) {

	    	Clientes cliente = clienteService.findById(clienteId);

	        if (cliente != null) {
	        	Turnos turno = new Turnos();
	        	turno.setClienteId(clienteId);  


	            model.addAttribute("cliente", cliente);
	            model.addAttribute("turno", turno);
	            return "crearTurno";  
	        } else {
	            model.addAttribute("error", "Cliente no encontrado");
	            return "error";
	        }
	    }

	    

	    @PostMapping("/guardarTurnos")
	    public String guardarTurno(@ModelAttribute("turno") Turnos turno, Model model) {
	    	if(turno.getFecha()!= null) {
	    		turnosService.save(turno);
	    		model.addAttribute("clienteId", turno.getClienteId());
	    		return "redirect:/cliente/" + turno.getClienteId() + "/turno";
	    	}else {
	    		model.addAttribute("error", "Falta ingresar un dato");
	    		return "error";
	    	}
	    }
	    
	    @GetMapping("/eliminarTurno/{id}")
		public String eliminar (@PathVariable(value="id")long id,Map<String,Object> model) {
			turnosService.deleteById(id);
			return "redirect:/listar";
			
		}
	    
	    @GetMapping("/editarTurno/{id}")
	    public String editarTurno(@PathVariable("id") Long id, Model model) {
	        Turnos turno = turnosService.findById(id);
	        
	        if (turno == null) {
	            model.addAttribute("error", "Turno no encontrado");
	            return "error";
	        }
	        
	        model.addAttribute("turno", turno);
	        return "editarTurno";  
	    }

	    @PostMapping("/actualizarTurno")
	    public String actualizarTurno(@ModelAttribute("turno") Turnos turno) {
	        turnosService.save(turno);
	        return "redirect:/cliente/" + turno.getClienteId() + "/turno";
	    }

	    

}
