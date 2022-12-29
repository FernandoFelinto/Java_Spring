package com.curso.boot.service;

import java.util.List;

import com.curso.boot.domain.Departamento;

public interface DepartamentoService {
	void salvar(Departamento departamento);
	void editar(Departamento departamento);
	Departamento buscaPorId(Long id);
	void excluir(Long id);
	List<Departamento> buscarTodos();
	boolean temCargos(Long id);
}
