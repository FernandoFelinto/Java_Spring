 package com.curso.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.boot.domain.Departamento;
import com.curso.boot.service.DepartamentoService;
@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	DepartamentoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "/departamento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos",service.buscarTodos());
		return "/departamento/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Departamento departamento) {
		service.salvar(departamento);
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", service.buscaPorId(id));
		return "/departamento/cadastro";
	}
	@PostMapping("/editar")
	public String editar(Departamento departamento) {
		service.editar(departamento);
		return "redirect:/departamentos/cadastrar";
	}
@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
	if (!service.temCargos(id)) {
			service.excluir(id);
	
	}
		
		return "redirect:/departamentos/listar";
	}

}
