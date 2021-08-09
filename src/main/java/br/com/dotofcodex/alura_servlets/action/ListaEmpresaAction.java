package br.com.dotofcodex.alura_servlets.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dotofcodex.alura_servlets.datasource.Banco;

public class ListaEmpresaAction {
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", Banco.getInstance().getEmpresas());

		RequestDispatcher rd = request.getRequestDispatcher("/listarEmpresa.jsp");
		rd.forward(request, response);
	}
}
