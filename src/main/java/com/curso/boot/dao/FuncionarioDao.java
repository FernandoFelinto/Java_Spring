package com.curso.boot.dao;

import java.time.LocalDate;
import java.util.List;

import com.curso.boot.domain.Funcionario;

public interface FuncionarioDao {
	void salvar(Funcionario funcionario);
	void editar(Funcionario funcionario);
	Funcionario buscaPorId(Long id);
	void excluir(Long id);
	List<Funcionario> buscarTodos();
	List<Funcionario> findByNome(String nome);
	List<Funcionario> findByCargoId(Long id);


}
