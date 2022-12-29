package com.curso.boot.dao;

import java.util.List;

import com.curso.boot.domain.Departamento;

public interface DepartamentoDao {
	void salvar(Departamento departamento);
	void editar(Departamento departamento);
	Departamento buscaPorId(Long id);
	void excluir(Long id);
	List<Departamento> buscarTodos();
}
