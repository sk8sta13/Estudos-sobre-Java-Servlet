package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empresaId = req.getParameter("id");
		Integer id = Integer.valueOf(empresaId);

		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresa(id);

		req.setAttribute("empresa", empresa);
	}
}
