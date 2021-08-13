package br.com.dotofcodex.alura_servlets.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dotofcodex.alura_servlets.action.WebAction;

public class ControladorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String webAction = request.getParameter("action");
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
			// o redirect é feito do lado do cliente, com o cabeçalho Location com a nova
			// url a ser chamada
		} else if ("redirect".equals(opAndUrl[0])) {
			response.sendRedirect(opAndUrl[1]);
		}
	}
}
