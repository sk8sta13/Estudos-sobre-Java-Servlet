package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		Date d = null;
		try {
			String data = req.getParameter("data");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			d = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa();
		empresa.setNome(req.getParameter("nome"));
		empresa.setData(d);
		
		Banco banco = new Banco();
		banco.salvar(empresa);

		/*out.println("<html>");
		out.println("<body>");
		out.println("<h1>Empresa " + req.getParameter("nome") + " cadastrada com sucesso.</h1>");
		out.println("</body>");
		out.println("</html>");*/

		resp.sendRedirect("listaEmpresas");
		/*RequestDispatcher rd = req.getRequestDispatcher("/nova_empresa.jsp");
		req.setAttribute("pageTitle", "Sucesso.");
		req.setAttribute("empresa", empresa);
		rd.forward(req, resp);*/
	}
}
