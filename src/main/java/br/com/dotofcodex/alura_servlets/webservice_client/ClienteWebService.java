package br.com.dotofcodex.alura_servlets.webservice_client;

import org.apache.http.client.fluent.Request;

public class ClienteWebService {
	public static void main(String[] args) throws Exception {
		String json = Request
			.Get("http://localhost:8080/alura-servlets/empresas")
			.addHeader("Accept", "application/json")
			.execute()
			.returnContent()
			.asString();
		
		System.out.println(json);
	}
}
