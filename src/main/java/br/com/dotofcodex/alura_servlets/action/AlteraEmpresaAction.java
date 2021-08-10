package br.com.dotofcodex.alura_servlets.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dotofcodex.alura_servlets.datasource.Banco;
import br.com.dotofcodex.alura_servlets.model.Empresa;

public class AlteraEmpresaAction implements WebAction {
	private AlteraEmpresaAction() {
		super();
	}

	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idEmpresa = request.getParameter("id");
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("data");

		Empresa empresa = new Empresa();
		empresa.setId(Long.valueOf(idEmpresa));
		empresa.setNome(nomeEmpresa);

		try {
			empresa.setDataAbertura(new SimpleDateFormat("dd/MM/yyyy").parse(dataAbertura));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha no Parsing da Data de Abertura");
		}

		Banco.getInstance().update(empresa);

		return "redirect:entrada?action=ListaEmpresas";
	}

	public static WebAction getInstance() {
		return new AlteraEmpresaAction();
	}
}
