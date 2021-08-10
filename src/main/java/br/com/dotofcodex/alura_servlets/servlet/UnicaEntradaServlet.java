package br.com.dotofcodex.alura_servlets.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dotofcodex.alura_servlets.action.AlteraEmpresaAction;
import br.com.dotofcodex.alura_servlets.action.ListaEmpresaAction;
import br.com.dotofcodex.alura_servlets.action.MostraEmpresaAction;
import br.com.dotofcodex.alura_servlets.action.NovaEmpresaAction;
import br.com.dotofcodex.alura_servlets.action.RemoveEmpresaAction;

/**
 * Essa classe faz o papel de Front-Controller repassando o objeto request e response para
 * um objeto especializado, com a unica responsabilidade de fazer o processamento.
 *
 * @author pedro
 *
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String webAction = request.getParameter("action");
		String url = null;
		if ("ListaEmpresas".equals(webAction)) {
			// chama o simple factory para obter uma nova instância do objeto
			url = ListaEmpresaAction.getInstance().executar(request, response);
		}
		else if ("MostraEmpresa".equals(webAction)) {
			// chama o simple factory para obter uma nova instância do objeto
			url = MostraEmpresaAction.getInstance().executar(request, response);
		}
		else if ("RemoveEmpresa".equals(webAction)) {
			// chama o simple factory para obter uma nova instância do objeto
			url = RemoveEmpresaAction.getInstance().executar(request, response);
		}
		else if ("AlteraEmpresa".equals(webAction)) {
			// chama o simple factory para obter uma nova instância do objeto
			url = AlteraEmpresaAction.getInstance().executar(request, response);
		}
		else if ("NovaEmpresa".equals(webAction)) {
			// chama o simple factory para obter uma nova instância do objeto
			url = NovaEmpresaAction.getInstance().executar(request, response);
		}
		
		final String[] opAndUrl = url.split("[:]");
		if ("forward".equals(opAndUrl[0])) {
			RequestDispatcher rd = request.getRequestDispatcher(opAndUrl[1]);
			rd.forward(request, response);
		}
		else if ("redirect".equals(opAndUrl[0])) {
			response.sendRedirect(opAndUrl[1]);
		}
	}
}
