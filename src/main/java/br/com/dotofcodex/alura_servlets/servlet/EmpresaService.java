package br.com.dotofcodex.alura_servlets.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.dotofcodex.alura_servlets.datasource.Banco;
import br.com.dotofcodex.alura_servlets.model.Empresa;

@WebServlet("/empresas")
public class EmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Empresa> empresas = Banco.getInstance().getEmpresas();

		String type = request.getHeader("Accept");
		if (type == null || "application/json".equals(type)) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas);

			response.setContentLength(json.length());
			response.setContentType("application/json");

			PrintWriter writer = response.getWriter();
			writer.write(json);
			writer.flush();
			return;
		}

		XStream xstream = new XStream();
		xstream.alias("empresa", Empresa.class);
		xstream.alias("lista", List.class);
		String xml = xstream.toXML(empresas);

		response.setContentLength(xml.length());
		response.setContentType("application/json");

		PrintWriter writer = response.getWriter();
		writer.write(xml);
		writer.flush();
	}
}
