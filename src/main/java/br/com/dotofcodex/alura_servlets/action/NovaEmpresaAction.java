package br.com.dotofcodex.alura_servlets.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dotofcodex.alura_servlets.datasource.Banco;
import br.com.dotofcodex.alura_servlets.model.Empresa;

public class NovaEmpresaAction implements WebAction {
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("data");

		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);

		try {
			empresa.setDataAbertura(new SimpleDateFormat("dd/MM/yyyy").parse(dataAbertura));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha no Parsing da Data de Abertura");
		}

		Banco.getInstance().adicionar(empresa);

		return "redirect:entrada?action=ListarEmpresas";
	}
}
