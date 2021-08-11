package br.com.dotofcodex.alura_servlets.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormNovaEmpresaAction implements WebAction {
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "forward:formNovaEmpresa.jsp";
	}
}
