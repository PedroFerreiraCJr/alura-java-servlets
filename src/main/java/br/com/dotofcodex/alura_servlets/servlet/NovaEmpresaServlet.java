package br.com.dotofcodex.alura_servlets.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dotofcodex.alura_servlets.datasource.Banco;
import br.com.dotofcodex.alura_servlets.model.Empresa;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empresa empresa = null;
		try {
			empresa = obterParametros(request);
		} catch (RuntimeException e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/empresaCriada.jsp");
			rd.forward(request, response);
			return;
		}

		Banco banco = Banco.getInstance();
		String action = request.getParameter("action");
		if ("atualizar".equals(action)) {
			banco.update(empresa);
			response.sendRedirect("listarEmpresas");
			return;
		}
		
		banco.adicionar(empresa);

		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("/listarEmpresas");
		 * rd.forward(request, response);
		 */

		response.sendRedirect("listarEmpresas");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("editar".equals(action)) {
			String id = request.getParameter("id");
			Empresa empresa = Banco.getInstance().getEmpresaPorId(Long.valueOf(id));
			request.setAttribute("empresa", empresa);
			RequestDispatcher rd = request.getRequestDispatcher("/formEditarEmpresa.jsp");
			rd.forward(request, response);
		}
		
		if ("remover".equals(action)) {
			String id = request.getParameter("id");
			Empresa empresa = Banco.getInstance().remover(Long.valueOf(id));
			if (empresa != null) {
				request.setAttribute("message", "Empresa removida com sucesso!");
			}
			RequestDispatcher rd = request.getRequestDispatcher("/listarEmpresa.jsp");
			rd.forward(request, response);
		}
	}
	
	private Empresa obterParametros(HttpServletRequest req) {
		String idEmpresa = req.getParameter("id");
		String nomeEmpresa = req.getParameter("nome");
		String dataAbertura = req.getParameter("data");

		Empresa empresa = new Empresa();
		if (idEmpresa != null) {
			empresa.setId(Long.valueOf(idEmpresa));
		}
		empresa.setNome(nomeEmpresa);

		try {
			empresa.setDataAbertura(new SimpleDateFormat("dd/MM/yyyy").parse(dataAbertura));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha no Parsing da Data de Abertura");
		}

		return empresa;
	}
}
