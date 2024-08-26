package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tutor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.TutorDao;


/**
* Servlet implementation class CategoriaAdd
*/
public class TutorAdd extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public TutorAdd() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// Extrair o nome
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			String endereco = request.getParameter("endereco");
		
			// Instaciar um tutor
			Tutor tutor = new Tutor();
			tutor.setNome(nome);
			tutor.setTelefone(telefone);
			tutor.setEndereco(endereco);

			
			//Salvar no SGBD
			TutorDao tutorDao = new TutorDao();
			try {
				tutorDao.adicionar(tutor);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//Exibir na Tela
			PrintWriter out = response.getWriter();
			out.println("Nome: " + nome);
			out.println("Telefone: " + telefone);
			out.println("Endereço: " + endereco);

			
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

}

