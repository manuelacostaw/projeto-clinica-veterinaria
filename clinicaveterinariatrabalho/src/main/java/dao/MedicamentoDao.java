package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Medicamento;

public class MedicamentoDao {

    private Connection con = null;

    public MedicamentoDao() {
        con = ConnectionFactory.getConnection();
    }

    public void adicionar(Medicamento medicamento) throws SQLException {
        String sql = "INSERT INTO medicamento(concentracao, idconsulta) VALUES (?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setFloat(1, medicamento.getConcentracao());
        stmt.setInt(2, medicamento.getConsulta().getId()); // Assumindo que Consulta é um objeto
        stmt.execute();
        stmt.close();
        con.close();
    }

    public void alterar(Medicamento medicamento) throws SQLException {
        String sql = "UPDATE medicamento SET concentracao = ?, idconsulta = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setFloat(1, medicamento.getConcentracao());
        stmt.setInt(2, medicamento.getConsulta().getId()); // Assumindo que Consulta é um objeto
        stmt.setInt(3, medicamento.getId());
        stmt.execute();
        stmt.close();
        con.close();
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM medicamento WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        con.close();
    }

    public Medicamento listarUm(int id) throws SQLException {
        String sql = "SELECT id, concentracao, idconsulta FROM medicamento WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        Medicamento medicamento = null;
        if (rs.next()) {
            medicamento = new Medicamento();
            medicamento.setId(rs.getInt("id"));
            medicamento.setConcentracao(rs.getFloat("concentracao"));
        }
        stmt.close();
        con.close();
        return medicamento;
    }

    public List<Medicamento> listarTodos() throws SQLException {
        String sql = "SELECT id, concentracao, idconsulta FROM medicamento";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Medicamento> medicamentos = new ArrayList<>();
        while (rs.next()) {
            Medicamento medicamento = new Medicamento();
            medicamento.setId(rs.getInt("id"));
            medicamento.setConcentracao(rs.getFloat("concentracao"));
            medicamentos.add(medicamento);
        }
        stmt.close();
        con.close();
        return medicamentos;
    }
}

