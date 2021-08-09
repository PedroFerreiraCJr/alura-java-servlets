package br.com.dotofcodex.alura_servlets.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dotofcodex.alura_servlets.datasource.Banco;
import br.com.dotofcodex.alura_servlets.model.Empresa;

public class RemoveEmpresaAction implements WebAction {
	private RemoveEmpresaAction() {
		super();
	}

	public void executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Empresa empresa = Banco.getInstance().remover(Long.valueOf(id));
		if (empresa != null) {
			request.setAttribute("message", "Empresa removida com sucesso!");
		}

		response.sendRedirect("entrada?action=ListarEmpresas");
	}

	public static WebAction getInstance() {
		return new RemoveEmpresaAction();
	}
}
