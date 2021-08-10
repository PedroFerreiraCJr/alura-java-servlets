package br.com.dotofcodex.alura_servlets.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dotofcodex.alura_servlets.datasource.Banco;
import br.com.dotofcodex.alura_servlets.model.Empresa;

public class MostraEmpresaAction implements WebAction {
	private MostraEmpresaAction() {
		super();
	}

	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Empresa empresa = Banco.getInstance().getEmpresaPorId(Long.valueOf(id));
		request.setAttribute("empresa", empresa);

		return "forward:/formEditarEmpresa.jsp";
	}

	public static WebAction getInstance() {
		return new MostraEmpresaAction();
	}
}
