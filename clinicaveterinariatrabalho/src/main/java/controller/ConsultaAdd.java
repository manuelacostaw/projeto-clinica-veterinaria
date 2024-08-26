package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Consulta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.ConsultaDao;

/**
 * Servlet implementation class ConsultaAdd
 */
//@WebServlet("/ConsultaAdd")
public class ConsultaAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// Obtém os parâmetros do formulário
        String tipo = request.getParameter("tipo");
        float valor = Float.valueOf(request.getParameter("valor"));
        float valorDesconto = Float.valueOf(request.getParameter("desconto"));
       
        
        // Cria um objeto Consulta com os dados do formulário
        Consulta consulta = new Consulta();
        consulta.setTipo(tipo);
        consulta.setValor(valor);
        consulta.setValorDesconto(valorDesconto);
        
        // Instancia o DAO para lidar com o banco de dados
        ConsultaDao consultaDao = new ConsultaDao();
        try {
            // Adiciona a consulta ao banco de dados
            consultaDao.adicionar(consulta);
        } catch (SQLException e) {
        	e.printStackTrace();
        
            
        }
      //Exibir na Tela
      		PrintWriter out = response.getWriter();
      		out.println("Tipo: " + tipo);
      		out.println("Valor: " + valor);
      		out.println("Desconto: " + valorDesconto);
      		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doGet(request, response);
	}

}
