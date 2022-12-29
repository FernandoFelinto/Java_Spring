package com.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.boot.dao.DepartamentoDao;
import com.curso.boot.domain.Departamento;
@Service @Transactional
public class DepartamentoServiceImpl implements DepartamentoService{
	@Autowired
	DepartamentoDao dao;
	@Override
	public void salvar(Departamento departamento) {
		dao.salvar(departamento);
		
	}

	@Override
	public void editar(Departamento departamento) {
		dao.editar(departamento);
		
	}

	@Override @Transactional(readOnly=true)
	public Departamento buscaPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.buscaPorId(id);
	}

	@Override
	public void excluir(Long id) {
		dao.excluir(id);
		
	}

	@Override @Transactional(readOnly=true)
	public List<Departamento> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.buscarTodos();
	}

	@Override
	public boolean temCargos(Long id) {
		if(buscaPorId(id).getCargos().isEmpty()) {
			return false;
		}
		else{return true;}
	}


}
