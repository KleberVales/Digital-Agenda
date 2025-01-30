package main.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Compromisso;

public class CompromissoDAO {
	private Connection conn;

	public CompromissoDAO() {
		try {

			String url = "jdbc:mysql://localhost:3306/agenda_db"; // URL do banco de dados
			String user = "root"; // Usuário do MySQL
			String password = "123456"; // Senha do MySQL

			conn = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salvarCompromisso(Compromisso compromisso) {

		String sql = "INSERT INTO compromissos (data, hora, descricao) VALUES (?, ?, ?)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, compromisso.getData());
			pstmt.setString(2, compromisso.getHora());
			pstmt.setString(3, compromisso.getDescricao());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Compromisso> listarCompromissos() {

		List<Compromisso> lista = new ArrayList<>();
		String sql = "SELECT * FROM compromissos";

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				lista.add(new Compromisso(

						rs.getInt("id"), rs.getString("data"), rs.getString("hora"), rs.getString("descricao")

				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void excluirCompromisso(int id) {
		String sql = "DELETE FROM compromissos WHERE id = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
