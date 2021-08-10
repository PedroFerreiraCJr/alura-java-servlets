package br.com.dotofcodex.alura_servlets.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dotofcodex.alura_servlets.datasource.Banco;

public class ListaEmpresaAction implements WebAction {
	private ListaEmpresaAction() {
		super();
	}
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", Banco.getInstance().getEmpresas());
		return "forward:/listarEmpresa.jsp";
	}
	
	public static WebAction getInstance() {
		return new ListaEmpresaAction();
	}
}
