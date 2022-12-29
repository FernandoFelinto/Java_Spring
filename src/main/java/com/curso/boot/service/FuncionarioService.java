package com.curso.boot.service;

import java.time.LocalDate;
import java.util.List;

import com.curso.boot.domain.Funcionario;

public interface FuncionarioService {
	void salvar(Funcionario funcionario);
	void editar(Funcionario funcionario);
	Funcionario buscaPorId(Long id);
	void excluir(Long id);
	List<Funcionario> buscarTodos();
	Object buscarPorNome(String nome);
	Object buscarPorCargo(Long id);

}
