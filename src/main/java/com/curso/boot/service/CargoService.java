package com.curso.boot.service;

import java.util.List;

import com.curso.boot.domain.Cargo;

public interface CargoService {
	void salvar(Cargo cargo);
	void editar(Cargo cargo);
	Cargo buscaPorId(Long id);
	void excluir(Long id);
	List<Cargo> buscarTodos();
	boolean cargoTemFuncionarios(Long id);
}
