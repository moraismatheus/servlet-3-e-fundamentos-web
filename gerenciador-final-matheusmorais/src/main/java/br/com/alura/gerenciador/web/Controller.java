package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet{

	
	/**
	 * @author moraism
	 */
	private static final long serialVersionUID = 6626322586019870362L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String tarefa = req.getParameter("tarefa");
		
		if (tarefa==null) {
			throw new IllegalArgumentException("");
		}
		
		String nomeClasse = "br.com.alura.gerenciador.web."+tarefa;
		try {
			Class tipo = Class.forName(nomeClasse);
			Tarefa instancia = (Tarefa) tipo.newInstance();
			String pagina = instancia.executa(req, resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	
}
