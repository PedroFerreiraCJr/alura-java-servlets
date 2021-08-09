package br.com.dotofcodex.alura_servlets.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WebAction {
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
