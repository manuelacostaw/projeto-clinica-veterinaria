package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import dao.ConsultaDao;

/**
 * Servlet implementation class ConsultaExcluir
 */
public class ConsultaExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaExcluir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtém o ID da consulta a ser excluída do parâmetro da requisição
	    int idConsulta = Integer.parseInt(request.getParameter("id"));

	    // Define o ID da consulta como um atributo no escopo da requisição
	    request.setAttribute("idDaConsulta", idConsulta);

	    // Encaminha a requisição para a página JSP responsável por exibir o formulário de exclusão
	    request.getRequestDispatcher("/WEB-INF/excluirConsulta.jsp").forward(request, response);
	  //response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        // Obtém o ID da consulta a ser excluída
        int id = Integer.parseInt(request.getParameter("id"));

        // Instancia o DAO para lidar com o banco de dados
        ConsultaDao consultaDao = new ConsultaDao();

        try {
            // Exclui a consulta do banco de dados
            consultaDao.excluir(id);

            // Redireciona para uma página de sucesso ou para a página de listagem de consultas
            response.sendRedirect("consultas.jsp?msg=Consulta excluída com sucesso!");
        } catch (SQLException e) {
            // Em caso de erro, redireciona para uma página de erro ou exibe uma mensagem de erro
            response.sendRedirect("erro.jsp?msg=Erro ao excluir consulta: " + e.getMessage());
        }		//doGet(request, response);
	}

}
