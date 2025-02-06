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

}
