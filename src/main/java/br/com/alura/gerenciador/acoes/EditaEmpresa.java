package br.com.alura.gerenciador.acoes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class EditaEmpresa implements Acao {
	public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String empresaId = req.getParameter("id");
		Integer id = Integer.valueOf(empresaId);

		Date d = null;
		try {
			String data = req.getParameter("data");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			d = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresa(id);

		empresa.setNome(nome);
		empresa.setData(d);
	}
}
