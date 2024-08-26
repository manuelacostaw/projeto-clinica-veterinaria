package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Agendamento;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.AgendamentoDao;

/**
 * Servlet implementation class AgendamentoListar
 */
public class AgendamentoListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendamentoListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instancia o DAO para lidar com o banco de dados
		
        AgendamentoDao agendamentoDao = new AgendamentoDao();
        List<Agendamento> agendamentos = null;
        try {
            agendamentos = agendamentoDao.listarTodos();     
        } catch (SQLException e) {
        	e.printStackTrace();
        }
     // Define o atributo na requisição para ser acessado pela página JSP
        request.setAttribute("agendamentos", agendamentos);

        String next = request.getParameter("next");
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
