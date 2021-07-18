package br.com.alura.gerenciador.acoes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {
	public void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Banco banco = new Banco();

		List<Empresa> lista = banco.getEmpresas();
		req.setAttribute("empresas", lista);
		req.setAttribute("pageTitle", "Lista de Empresas");
	}
}
