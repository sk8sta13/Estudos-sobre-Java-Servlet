package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> lUsuario = new ArrayList<>();
	private static Integer chaveSequencial = 1; 

	static {
		Usuario u = new Usuario();
		u.setLogin("marcelo");
		u.setSenha("123");
		lUsuario.add(u);
	}

	public Usuario login(String login, String senha) {
		for (Usuario u : Banco.lUsuario) {
			if (u.igual(login, senha)) {
				return u;
			}
		}
		return null;
	}
	
	public void salvar(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();

		while(it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresa(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}

		return null;
	}
}
