package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.AgendamentoDao;

/**
 * Servlet implementation class AgendamentoExcluir
 */
public class AgendamentoExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendamentoExcluir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// Obtém o ID do agendamento a ser excluído
        int id = Integer.parseInt(request.getParameter("id"));

        // Instancia o DAO para lidar com o banco de dados
        AgendamentoDao agendamentoDao = new AgendamentoDao();

        try {
            // Exclui o agendamento do banco de dados
            agendamentoDao.excluir(id);

        } catch (SQLException e) {
            // Em caso de erro, redireciona para uma página de erro ou exibe uma mensagem de erro
            response.sendRedirect("erro.jsp?msg=Erro ao excluir agendamento: " + e.getMessage());
        }		//doGet(request, response);
      //Exibir na Tela
      		PrintWriter out = response.getWriter();
      		out.println("AgendamentoId: " + id + " excluido");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        
	}

}
