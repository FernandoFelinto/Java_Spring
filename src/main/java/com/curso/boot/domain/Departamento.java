package com.curso.boot.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="DEPARTAMENTO")
public class Departamento extends AbstractEntity<Long>{
	
	@Column(nullable=false)
	private String nome;
	
	@OneToMany(mappedBy="departamento")
	List<Cargo> cargos;

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
