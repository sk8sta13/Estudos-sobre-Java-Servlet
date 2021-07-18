package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/Empresa")
public class EmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		List<Empresa> empresas = new Banco().getEmpresas();

		/*Gson gson = new Gson();
		String json = gson.toJson(empresas);
		
		resp.setContentType("application/json");
		resp.getWriter().print(json);*/

		XStream xstream = new XStream();
		String xml = xstream.toXML(empresas);

		resp.setContentType("application/xml");
		resp.getWriter().print(xml);
	}
}
