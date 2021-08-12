package br.com.dotofcodex.alura_servlets.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dotofcodex.alura_servlets.action.WebAction;

/**
 * Essa classe faz o papel de Front-Controller repassando o objeto request e
 * response para um objeto especializado, com a unica responsabilidade de fazer
 * o processamento.
 *
 * @author Pedro Junior
 *
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String webAction = request.getParameter("action");
		
		HttpSession session = request.getSession();
		boolean usuarioNaoEstaLogado = session.getAttribute("usuarioLogado") == null;
		boolean eUmaWebActionProtegida = !("Login".equals(webAction) || "FormLogin".equals(webAction));
		if (eUmaWebActionProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?action=FormLogin");
			return;
		}
		
		
		String url = null;
		try {
			Class<?> clazz = Class.forName(String.format("br.com.dotofcodex.alura_servlets.action.%sAction", webAction));
			WebAction action = (WebAction) clazz.newInstance();
			url = action.executar(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		// processa a url retornada pelo método executar de cada WebAction
		final String[] opAndUrl = url.split("[:]");
		// o forward vai para a JSP
		if ("forward".equals(opAndUrl[0])) {
			RequestDispatcher rd = request.getRequestDispatcher(String.format("WEB-INF/view/%s", opAndUrl[1]));
			rd.forward(request, response);
		// o redirect é feito do lado do cliente, com o cabeçalho Location com a nova url a ser chamada
		} else if ("redirect".equals(opAndUrl[0])) {
			response.sendRedirect(opAndUrl[1]);
		}
	}
}
