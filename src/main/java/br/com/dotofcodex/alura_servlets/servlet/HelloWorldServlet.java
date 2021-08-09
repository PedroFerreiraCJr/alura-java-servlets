package br.com.dotofcodex.alura_servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi")
public class HelloWorldServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
			out.println("<head>");
				out.println("<title>Bem-vindo</title>");
			out.println("</head>");
			out.println("<body>");
				out.println("<p>Bem-vindo ao curso da Alura Servlets</p>");
			out.println("</body>");
		out.println("</html>");
		out.flush();
	}
}
