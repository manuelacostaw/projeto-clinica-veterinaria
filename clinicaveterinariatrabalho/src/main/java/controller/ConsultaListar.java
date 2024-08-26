package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import dao.ConsultaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Consulta;

/**
 * Servlet implementation class ConsultaListar
 */
public class ConsultaListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConsultaDao consultaDao = new ConsultaDao();
		List<Consulta> consultas = null;
		try {
			consultas = consultaDao.listarTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("consultas", consultas);
		
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
