package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tutor;

public class TutorDao {

    private Connection con = null;

    public TutorDao() {
        con = ConnectionFactory.getConnection();
    }

    public void adicionar(Tutor tutor) throws SQLException {
        String sql = "INSERT INTO tutor(nome, telefone, endereco) VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, tutor.getNome());
        stmt.setString(2, tutor.getTelefone());
        stmt.setString(3, tutor.getEndereco());
        stmt.execute();
        stmt.close();
        con.close();
    }

    public void alterar(Tutor tutor) throws SQLException {
        String sql = "UPDATE tutor SET nome = ?, telefone = ?, endereco = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, tutor.getNome());
        stmt.setString(2, tutor.getTelefone());
        stmt.setString(3, tutor.getEndereco());
        stmt.setInt(4, tutor.getId());
        stmt.execute();
        stmt.close();
        con.close();
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM tutor WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        con.close();
    }

    public Tutor listarUm(int id) throws SQLException {
        String sql = "SELECT id, nome, telefone, endereco FROM tutor WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        Tutor tutor = null;
        if (rs.next()) {
            tutor = new Tutor();
            tutor.setId(rs.getInt("id"));
            tutor.setNome(rs.getString("nome"));
            tutor.setTelefone(rs.getString("telefone"));
            tutor.setEndereco(rs.getString("endereco"));
        }
        stmt.close();
        con.close();
        return tutor;
    }

    public List<Tutor> listarTodos() throws SQLException {
        String sql = "SELECT id, nome, telefone, endereco FROM tutor";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Tutor> tutores = new ArrayList<Tutor>();
        while (rs.next()) {
            Tutor tutor = new Tutor();
            tutor.setId(rs.getInt("id"));
            tutor.setNome(rs.getString("nome"));
            tutor.setTelefone(rs.getString("telefone"));
            tutor.setEndereco(rs.getString("endereco"));
            tutores.add(tutor);
        }
        stmt.close();
        con.close();
        return tutores;
    }

}
