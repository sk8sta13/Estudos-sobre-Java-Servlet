package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acoes.*;

@WebServlet("/entrada")
public class unicaEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String acao = req.getParameter("acao");
		String c = "br.com.alura.gerenciador.acoes." + acao;

		try {
			Class classe = Class.forName(c);
			Acao a = (Acao) classe.newInstance();
			a.executa(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IOException e) {
			throw new ServletException(e); 
		}

		if (acao.equals("ListaEmpresas")) {
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/lista_empresas.jsp");
			rd.forward(req, resp);
		} else if (acao.equals("RemoveEmpresa")) {
			resp.sendRedirect("entrada?acao=ListaEmpresas");
		} else if (acao.equals("MostraEmpresa")) {
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/mostra_empresa.jsp");
			rd.forward(req, resp);
		} else if (acao.equals("EditaEmpresa")) {
			resp.sendRedirect("entrada?acao=ListaEmpresas");
		} else if (acao.equals("CadastraEmpresa")) {
			resp.sendRedirect("entrada?acao=ListaEmpresas");
		} else if (acao.equals("FormNovaEmpresa")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/FormNovaEmpresa.jsp");
			rd.forward(req, resp);
		} else if (acao.equals("LoginForm")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/LoginForm.jsp");
			rd.forward(req, resp);
		} else if (acao.equals("Login")) {
			resp.sendRedirect("entrada?acao=ListaEmpresas");
		} else if (acao.equals("Logout")){
			resp.sendRedirect("entrada?acao=LoginForm");
		} else {
			System.out.println("Opção inválida.");
		}
	}
}
