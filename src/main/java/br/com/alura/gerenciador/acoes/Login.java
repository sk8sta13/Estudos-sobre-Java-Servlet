package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		Banco banco = new Banco();
		Usuario u = banco.login(login, senha);

		if (u != null) {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", u);
		}
	}

}
