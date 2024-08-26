package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Consulta;

public class ConsultaDao {

private Connection con = null;
	
public ConsultaDao() {
    con = ConnectionFactory.getConnection();
}

	public void adicionar(Consulta consulta) throws SQLException {
	    String sql = "insert into consulta(tipo, valor, valorDesconto) values (?,?,?)";
	    PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setString(1, consulta.getTipo());
	    stmt.setFloat(2, consulta.getValor());
	    stmt.setFloat(3, consulta.getValorDesconto());
	    stmt.execute();
	    stmt.close();
	    con.close();
	}
	
	public void alterar(Consulta consulta) throws SQLException {
		String sql = "update consulta set tipo = ?, valor = ?, valorDesconto = ? where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, consulta.getTipo());
		stmt.setFloat(2, consulta.getValor());
		stmt.setFloat(3, consulta.getValorDesconto());
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void excluir(int id) throws SQLException {
		String sql = "delete from consulta where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public Consulta listarUm(int id) throws SQLException {
		String sql = "select id, tipo, valor, valorDesconto from consulta "
				+ " where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		Consulta consulta = null;
		if(rs.next()) {
			consulta = new Consulta();
			consulta.setId(rs.getInt("id"));
			consulta.setTipo(rs.getString("tipo"));
			consulta.setValor(rs.getFloat("valor"));
			consulta.setValorDesconto(rs.getFloat("valorDesconto"));
		}
		stmt.close();
		con.close();
		return consulta;
	}

	public List<Consulta> listarTodos() throws SQLException {
		String sql = "select id, tipo, valor, valorDesconto from consulta";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		
		Consulta consulta = null;
		List<Consulta> consultas = new ArrayList<Consulta>();
		while(rs.next()) {
			consulta = new Consulta();
			consulta.setId(rs.getInt("id"));
			consulta.setTipo(rs.getString("tipo"));
			consulta.setValor(rs.getFloat("valor"));
			consulta.setValorDesconto(rs.getFloat("valorDesconto"));
			consultas.add(consulta);
		}
		stmt.close();
		con.close();
		return consultas;
	}
}
