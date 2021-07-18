package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/entrada")
public class Autorizacao implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		String acao = req.getParameter("acao");

		if ((!acao.equals("LoginForm")) && (!acao.equals("Login")) && (session.getAttribute("usuarioLogado") == null)) {
			resp.sendRedirect("entrada?acao=LoginForm");
		} else {
			chain.doFilter(request, response);
		}
	}
}
