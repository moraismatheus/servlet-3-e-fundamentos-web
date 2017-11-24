package br.com.alura.gerenciador.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa implements Tarefa{

	@Override
		public String executa(HttpServletRequest req, HttpServletResponse resp) {
			String filtro = req.getParameter("nome");
			Empresa empresaAdicionada = new Empresa(filtro);
			new EmpresaDAO().adiciona(empresaAdicionada);
			req.setAttribute("empresa", empresaAdicionada);
			return "WEB-INF/paginas/novaEmpresa.jsp";
		}
}
