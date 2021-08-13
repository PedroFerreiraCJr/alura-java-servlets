package br.com.dotofcodex.alura_servlets.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String webAction = httpRequest.getParameter("action");
		HttpSession session = httpRequest.getSession();
		boolean usuarioNaoEstaLogado = session.getAttribute("usuarioLogado") == null;
		boolean eUmaWebActionProtegida = !("Login".equals(webAction) || "FormLogin".equals(webAction));
		if (eUmaWebActionProtegida && usuarioNaoEstaLogado) {
			httpResponse.sendRedirect("entrada?action=FormLogin");
			return;
		}

		chain.doFilter(request, response);
	}
}
