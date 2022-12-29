package com.curso.boot.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="FUNCIONARIOS")
public class Funcionario extends AbstractEntity<Long> {
	@Column(nullable=false)
	private String nome;
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00") 
	@Column(nullable=false, columnDefinition="DECIMAL(7,2)")
	private BigDecimal salario;
	@DateTimeFormat(iso = ISO.DATE) 
	@Column(nullable=false, columnDefinition="DATE")
	private LocalDate dataEntrada;
	@DateTimeFormat(iso = ISO.DATE) 
	@Column(columnDefinition="DATE")
	private LocalDate dataSaida;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="endereco_id_fk")
	private Endereco endereco;
	
	@ManyToOne @JoinColumn(name="id_cargo_fk")
	private Cargo cargo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
}
