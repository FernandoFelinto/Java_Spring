package com.curso.boot.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.boot.dao.FuncionarioDao;
import com.curso.boot.domain.Funcionario;
@Service @Transactional
public class FuncionarioServiceImpl implements FuncionarioService{
	@Autowired
	FuncionarioDao dao;
	@Override
	public void salvar(Funcionario funcionario) {
		dao.salvar(funcionario);
		
	}

	@Override
	public void editar(Funcionario funcionario) {
		dao.editar(funcionario);
		
	}

	@Override @Transactional(readOnly=true)
	public Funcionario buscaPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.buscaPorId(id);
	}

	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		dao.excluir(id);
	}

	@Override @Transactional(readOnly=true)
	public List<Funcionario> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.buscarTodos();
	}
	@Override @Transactional(readOnly = true)
	public List<Funcionario> buscarPorNome(String nome) {
		
		return dao.findByNome(nome);
	}

	@Override @Transactional(readOnly = true)
	public List<Funcionario> buscarPorCargo(Long id) {
		
		return dao.findByCargoId(id);
	}



}
