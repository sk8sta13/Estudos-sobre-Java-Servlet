package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class listaEmpresas
 */
@WebServlet("/listaEmpresas")
public class listaEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		Banco banco = new Banco();

		List<Empresa> lista = banco.getEmpresas();
		req.setAttribute("empresas", lista);
		req.setAttribute("pageTitle", "Lista de Empresas");

		RequestDispatcher rd = req.getRequestDispatcher("/lista_empresas.jsp");
		rd.forward(req, res);
	}

}
