package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Agendamento;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import dao.AgendamentoDao;
/**
 * Servlet implementation class AgendamentoAlterar
 */
public class AgendamentoAlterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendamentoAlterar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        // Obtém os parâmetros do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        LocalDate data = LocalDate.parse(request.getParameter("data"));
        LocalTime hora = LocalTime.parse(request.getParameter("hora"));

        // Cria um objeto Agendamento com os dados do formulário
        Agendamento agendamento = new Agendamento(data, hora);
        agendamento.setId(id);
        agendamento.setData(data);
        agendamento.setHora(hora);

        // Instancia o DAO para lidar com o banco de dados
        AgendamentoDao agendamentoDao = new AgendamentoDao();

        try {
            // Atualiza o agendamento no banco de dados
            agendamentoDao.alterar(agendamento);

            // Redireciona para uma página de sucesso ou para a página de listagem de agendamentos
            response.sendRedirect("agendamentos.jsp?msg=Agendamento alterado com sucesso!");
        } catch (SQLException e) {
            // Em caso de erro, redireciona para uma página de erro ou exibe uma mensagem de erro
            response.sendRedirect("erro.jsp?msg=Erro ao alterar agendamento: " + e.getMessage());
        }
		//doGet(request, response);
	}

}
