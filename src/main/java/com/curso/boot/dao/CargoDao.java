package com.curso.boot.dao;

import java.util.List;

import com.curso.boot.domain.Cargo;


public interface CargoDao {
	void salvar(Cargo cargo);
	void editar(Cargo cargo);
	Cargo buscaPorId(Long id);
	void excluir(Long id);
	List<Cargo> buscarTodos();
}
