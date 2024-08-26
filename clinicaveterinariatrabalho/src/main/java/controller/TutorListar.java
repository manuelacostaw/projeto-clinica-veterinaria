package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.TutorDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tutor;

public class TutorListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TutorListar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. Instanciar o CategoriaDao
		 * 2. Fazer um List de categorias
		 * 3. Despachar para a página categorialistar.jsp
		 */
		
		TutorDao tutorDao = new TutorDao();
		List<Tutor> tutores = null;
		try {
			tutores = tutorDao.listarTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("tutores", tutores);
		
		String next = request.getParameter("next");
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}