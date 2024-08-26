package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Animal;

public class AnimalDao {

    private Connection con = null;
    
    public AnimalDao() {
        con = ConnectionFactory.getConnection();
    }
    
   
    public void adicionar(Animal animal) throws SQLException {
        String sql = "INSERT INTO animal(nome, especie, raca, peso, idade, genero, idtutor) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, animal.getNome());
        stmt.setString(2, animal.getEspecie());
        stmt.setString(3, animal.getRaca());
        stmt.setFloat(4, animal.getPeso());
        stmt.setInt(5, animal.getIdade());
        stmt.setString(6, animal.getGenero());
        stmt.setInt(7, animal.getTutor().getId());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    
    public void alterar(Animal animal) throws SQLException {
        String sql = "UPDATE animal SET nome = ?, especie = ?, raca = ?, peso = ?, idade = ?, genero = ?, idtutor = ? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, animal.getNome());
        stmt.setString(2, animal.getEspecie());
        stmt.setString(3, animal.getRaca());
        stmt.setFloat(4, animal.getPeso());
        stmt.setInt(5, animal.getIdade());
        stmt.setString(6, animal.getGenero());
        stmt.setInt(7, animal.getTutor().getId());
        stmt.setInt(8, animal.getId());
        stmt.execute();
        stmt.close();
        con.close();
    }
    
  
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM animal WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        con.close();
    }
    
    
    public Animal listarUm(int id) throws SQLException {
        String sql = "SELECT id, nome, especie, raca, peso, idade, genero, idtutor FROM animal WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        Animal animal = null;
        if (rs.next()) {
            animal = new Animal();
            animal.setId(rs.getInt("id"));
            animal.setNome(rs.getString("nome"));
            animal.setEspecie(rs.getString("especie"));
            animal.setRaca(rs.getString("raca"));
            animal.setPeso(rs.getFloat("peso"));
            animal.setIdade(rs.getInt("idade"));
            animal.setGenero(rs.getString("genero"));
        }
        stmt.close();
        con.close();
        return animal;
    }
    
   
    public List<Animal> listarTodos() throws SQLException {
        String sql = "SELECT id, nome, especie, raca, peso, idade, genero, idtutor FROM animal";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        Animal animal = null;
        List<Animal> animais = new ArrayList<Animal>();
        
        while(rs.next()) {
            animal = new Animal();
            animal.setId(rs.getInt("id"));
            animal.setNome(rs.getString("nome"));
            animal.setEspecie(rs.getString("especie"));
            animal.setRaca(rs.getString("raca"));
            animal.setPeso(rs.getFloat("peso"));
            animal.setIdade(rs.getInt("idade"));
            animal.setGenero(rs.getString("genero"));
            animais.add(animal);
        }
        stmt.close();
        con.close();
        return animais;
    }

}
