package br.com.dotofcodex.alura_servlets.model;

import java.util.Date;

public class Empresa {
	private Long id;
	private String nome;
	private Date dataAbertura = new Date();

	public Empresa() {
		super();
	}

	public Empresa(String nome) {
		super();
		this.nome = nome;
	}
	
	public Empresa(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
}
