package dao;

import model.Agenda;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {
	
    public void salvar(Agenda agenda) throws SQLException {
    	
        String sql = "INSERT INTO Agenda (ano, mes, dia, hora) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, agenda.getAno());
            stmt.setInt(2, agenda.getMes());
            stmt.setInt(3, agenda.getDia());
            stmt.setInt(4, agenda.getHora());
            stmt.executeUpdate();
        }
    }

    public List<Agenda> listar() throws SQLException {
        List<Agenda> agendas = new ArrayList<>();
        String sql = "SELECT * FROM Agenda";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Agenda agenda = new Agenda();
                agenda.setId(rs.getInt("id"));
                agenda.setAno(rs.getInt("ano"));
                agenda.setMes(rs.getInt("mes"));
                agenda.setDia(rs.getInt("dia"));
                agenda.setHora(rs.getInt("hora"));
                agendas.add(agenda);
            }
        }
        return agendas;
    }
}
