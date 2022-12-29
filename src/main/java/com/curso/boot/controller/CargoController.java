package com.curso.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.curso.boot.domain.Cargo;
import com.curso.boot.domain.Departamento;
import com.curso.boot.service.CargoService;
import com.curso.boot.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	@Autowired
	private CargoService cargoService;
	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cargoService.buscarTodos());
		return "/cargo/lista"; 
	}
	
	@PostMapping("/salvar")
	public String salvar(Cargo cargo) {
		cargoService.salvar(cargo);
		
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.buscaPorId(id));
		return "cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cargo cargo) {
		cargoService.editar(cargo);
		
		return "redirect:/cargos/cadastrar";
	}
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		if (!cargoService.cargoTemFuncionarios(id)) {
			
			cargoService.excluir(id);
			
		}
		return "redirect:/cargos/listar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos() {
		return departamentoService.buscarTodos();
	}	

}
