package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Acao {
	// Por default ja é public e abstrato.
	void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
