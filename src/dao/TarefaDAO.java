package dao;

import model.Tarefa;
import util.DatabaseConnection;

import java.sql.*;

public class TarefaDAO {
    public void salvar(Tarefa tarefa) throws SQLException {
    	
        String sql = "INSERT INTO Tarefa (agenda_id, descricao) VALUES (?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tarefa.getAgendaId());
            stmt.setString(2, tarefa.getDescricao());
            stmt.executeUpdate();
        }
    }
}
