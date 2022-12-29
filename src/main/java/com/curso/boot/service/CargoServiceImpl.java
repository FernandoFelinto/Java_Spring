package com.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.boot.dao.CargoDao;
import com.curso.boot.domain.Cargo;

@Service @Transactional
public class CargoServiceImpl implements CargoService{
	@Autowired
	CargoDao dao;
	
	@Override
	public void salvar(Cargo cargo) {
		dao.salvar(cargo);
		
	}

	@Override
	public void editar(Cargo cargo) {
		dao.editar(cargo);
		
	}

	@Override @Transactional(readOnly=true)
	public Cargo buscaPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.buscaPorId(id);
	}

	@Override
	public void excluir(Long id) {
		dao.excluir(id);
		
	}

	@Override @Transactional(readOnly=true)
	public List<Cargo> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.buscarTodos();
	}


	@Override
	public boolean cargoTemFuncionarios(Long id) {
		if (buscaPorId(id).getFuncionarios().isEmpty()) {
			return false;
		}
		return true;
	}

	

}
