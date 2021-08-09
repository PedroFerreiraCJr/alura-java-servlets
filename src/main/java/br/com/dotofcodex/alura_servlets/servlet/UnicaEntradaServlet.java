package br.com.dotofcodex.alura_servlets.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dotofcodex.alura_servlets.action.ListaEmpresaAction;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String webAction = request.getParameter("action");
		if ("listarEmpresas".equals(webAction)) {
			ListaEmpresaAction act = new ListaEmpresaAction();
			act.executar(request, response);
		}
		else if ("RemoverEmpresa".equals(webAction)) {
			
		}
		else if ("MostrarEmpresa".equals(webAction)) {
			
		}
	}
}
