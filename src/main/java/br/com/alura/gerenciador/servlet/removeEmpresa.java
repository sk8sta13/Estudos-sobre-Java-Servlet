package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/removeEmpresa")
public class removeEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empresaId = request.getParameter("id");
		Integer id = Integer.valueOf(empresaId);

		Banco banco = new Banco();
		banco.removeEmpresa(id);

		response.sendRedirect("listaEmpresas");
	}

}
