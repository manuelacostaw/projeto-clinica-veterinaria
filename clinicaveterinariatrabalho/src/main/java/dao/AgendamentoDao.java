package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import java.time.LocalDate;

import model.Agendamento;

public class AgendamentoDao {
    
    private Connection con = null;
    
    public AgendamentoDao() {
        con = ConnectionFactory.getConnection();
    }
    
    public void adicionar(Agendamento agendamento) throws SQLException {
        String sql = "insert into agendamento(data, hora) values (?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setObject(1, agendamento.getData());
        stmt.setObject(2, agendamento.getHora());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public void alterar(Agendamento agendamento) throws SQLException {
        String sql = "update agendamento set data = ?, hora = ? where id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setObject(1, agendamento.getData());
        stmt.setObject(2, agendamento.getHora());
        stmt.setInt(3, agendamento.getId());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public void excluir(int id) throws SQLException {
        String sql = "delete from agendamento where id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    public Agendamento listarUm(int id) throws SQLException {
        String sql = "select id, data, hora from agendamento where id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        Agendamento agendamento = null;
        if (rs.next()) {
            agendamento = new Agendamento();
            agendamento.setId(rs.getInt("id"));
            agendamento.setData(rs.getObject("data", LocalDate.class));
            agendamento.setHora(rs.getObject("hora", LocalTime.class));
        }
        stmt.close();
        con.close();
        return agendamento;
    }
    
    public List<Agendamento> listarTodos() throws SQLException {
        String sql = "select id, data, hora from agendamento";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        Agendamento agendamento = null;
        
        List<Agendamento> agendamentos = new ArrayList<Agendamento>();
        while (rs.next()) {
            agendamento = new Agendamento();
            agendamento.setId(rs.getInt("id"));
            agendamento.setData(rs.getObject("data", LocalDate.class));
            agendamento.setHora(rs.getObject("hora", LocalTime.class));
            agendamentos.add(agendamento);
        }
        stmt.close();
        con.close();
        return agendamentos;
    }
}










