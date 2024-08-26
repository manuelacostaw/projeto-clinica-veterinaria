package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import dao.AgendamentoDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Agendamento;

/**
 * Servlet implementation class AgendamentoAdd
 */
public class AgendamentoAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendamentoAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pegando os parametros do form
	    LocalDate data = LocalDate.parse(request.getParameter("data"));
	    LocalTime hora = LocalTime.parse(request.getParameter("hora"));
	    
	    
	    //instanciando um novo obj agendamento
	    Agendamento agendamento = new Agendamento(data, hora);
		
		//chamando metodo adicionar de agendamentodao p salvar agendamento no sgbd
	    AgendamentoDao agendamentoDao = new AgendamentoDao();
	    try {
	        agendamentoDao.adicionar(agendamento);
	    } catch (SQLException e) {
	        //tratamento de exceçao p caso de erro    
	        e.printStackTrace();
	        response.sendRedirect("erro.jsp");
	    }
	  //Exibir na Tela
	  		PrintWriter out = response.getWriter();
	  		out.println("Data: " + data);
	  		out.println("Hora: " + hora);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    doGet(request, response);
		}

}

