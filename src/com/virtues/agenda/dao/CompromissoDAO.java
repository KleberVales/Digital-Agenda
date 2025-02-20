package com.virtues.agenda.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtues.agenda.model.Compromisso;

public class CompromissoDAO {

	private Connection conn;

	public CompromissoDAO() {

		String url = "jdbc:mysql://localhost:3306/agenda_db";
		String name = "root";
		String password = "123456";

		try {

			conn = DriverManager.getConnection(url, name, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salvarCompromisso(Compromisso compromisso) {

		String sql = "INSERT INTO compromissos(data, hora, descricao) values(?, ?, ?)";

		try (PreparedStatement ptmt = conn.prepareStatement(sql)) {

			ptmt.setString(1, compromisso.getData());
			ptmt.setString(2, compromisso.getHora());
			ptmt.setString(3, compromisso.getDescricao());
			ptmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Compromisso> listarCompromisso() {

		List<Compromisso> lista = new ArrayList<Compromisso>();

		String sql = "SELECT * FROM compromissos";

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				lista.add(new Compromisso(rs.getInt("id"), rs.getString("data"), rs.getString("hora"),
						rs.getString("descricao")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void remover(int id) {
		
		String sql = "DELETE FROM compromissos where id = ?";
		
		try(PreparedStatement ptmt = conn.prepareStatement(sql)){
			
			ptmt.setInt(1, id);
			ptmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void modifiedCompromisso(Compromisso compromisso) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE compromissos SET data = ?, hora = ?, descricao = ? WHERE id = ?";
	    
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, compromisso.getData());
	        stmt.setString(2, compromisso.getHora());
	        stmt.setString(3, compromisso.getDescricao());
	        stmt.setInt(4, compromisso.getID());

	        int linhasAfetadas = stmt.executeUpdate();
	        if (linhasAfetadas > 0) {
	            System.out.println("Compromisso atualizado com sucesso!");
	        } else {
	            System.out.println("Nenhum compromisso encontrado com esse ID.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

}
