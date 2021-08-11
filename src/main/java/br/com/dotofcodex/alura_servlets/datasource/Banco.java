package br.com.dotofcodex.alura_servlets.datasource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.dotofcodex.alura_servlets.model.Empresa;
import br.com.dotofcodex.alura_servlets.model.Usuario;

public class Banco {

	private static Banco instance;
	private long nextId;
	private List<Empresa> lista = new ArrayList<>();
	private List<Usuario> usuarios = new ArrayList<>();

	private Banco() {
		super();
		init();
	}
	
	private void init() {
		Usuario nico = new Usuario();
		nico.setLogin("nico");
		nico.setSenha("12345");
		usuarios.add(nico);
		
		Usuario ana = new Usuario();
		ana.setLogin("ana");
		ana.setSenha("12345");
		usuarios.add(ana);
	}

	public void adicionar(Empresa empresa) {
		empresa.setId(++nextId);
		this.lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return this.lista;
	}

	public void update(Empresa empresa) {
		Iterator<Empresa> iterator = this.lista.iterator();
		while (iterator.hasNext()) {
			Empresa e = iterator.next();
			if (e.getId().equals(empresa.getId())) {
				iterator.remove();
				break;
			}
		}
		this.lista.add(empresa);
	}
	
	public Empresa remover(Long id) {
		Iterator<Empresa> iterator = this.lista.iterator();
		while (iterator.hasNext()) {
			Empresa e = iterator.next();
			if (id.equals(id)) {
				iterator.remove();
				return e;
			}
		}
		return null;
	}
	
	public Empresa getEmpresaPorId(Long id) {
		for (Empresa e: this.lista) {
			if (id.equals(e.getId())) {
				return e;
			}
		}
		return null;
	}
	
	public Usuario existeUsuario(String login, String senha) {
		for (final Usuario user: usuarios) {
			if (user.ehIgual(login, senha)) {
				return user;
			}
		}
		return null;
	}
	
	public static Banco getInstance() {
		if (instance == null) {
			synchronized (Banco.class) {
				if (instance == null) {
					instance = new Banco();
				}
			}
		}

		return instance;
	}
}
