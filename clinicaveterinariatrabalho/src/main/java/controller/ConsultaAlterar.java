package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Consulta;

import java.io.IOException;
import java.sql.SQLException;

import dao.ConsultaDao;

/**
 * Servlet implementation class ConsultaAlterar
 */
public class ConsultaAlterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaAlterar() {
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

        // p pegar os parâmetros do formulário
        int id = Integer.parseInt(request.getParameter("id"));
        String tipo = request.getParameter("tipo");
        float valor = Float.parseFloat(request.getParameter("valor"));
        float valorDesconto = Float.parseFloat(request.getParameter("desconto"));

        // ai cria um objeto Consulta com os dados do form
        Consulta consulta = new Consulta();
        consulta.setId(id);
        consulta.setTipo(tipo);
        consulta.setValor(valor);
        consulta.setValorDesconto(valorDesconto);

        // Instancia o DAO para lidar com o banco de dados
        ConsultaDao consultaDao = new ConsultaDao();

        try {
            // Atualiza a consulta no banco de dados
            consultaDao.alterar(consulta);

            // Redireciona para uma página de sucesso ou para a página de listagem de consultas
            response.sendRedirect("consultas.jsp?msg=Consulta alterada com sucesso!");
        } catch (SQLException e) {
            // Em caso de erro, redireciona para uma página de erro ou exibe uma mensagem de erro
            response.sendRedirect("erro.jsp?msg=Erro ao alterar consulta: " + e.getMessage());
        }
		//doGet(request, response);
	}

}
