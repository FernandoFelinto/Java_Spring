package com.curso.boot.domain;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractEntity <ID extends Serializable>
implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
	
}
