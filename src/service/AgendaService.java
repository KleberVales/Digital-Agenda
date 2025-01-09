package service;

import dao.AgendaDAO;
import dao.TarefaDAO;
import model.Agenda;
import model.Tarefa;

import java.sql.SQLException;
import java.util.List;

public class AgendaService {
	private final AgendaDAO agendaDAO = new AgendaDAO();
	private final TarefaDAO tarefaDAO = new TarefaDAO();

	public void adicionarAgenda(int ano, int mes, int dia, int hora, String descricao) throws SQLException {

		Agenda agenda = new Agenda();

		agenda.setAno(ano);
		agenda.setMes(mes);
		agenda.setDia(dia);
		agenda.setHora(hora);
		agenda.setDescricao(descricao);

		agendaDAO.salvar(agenda);
	}

	public void adicionarTarefa(int agendaId, String descricao) throws SQLException {

		Tarefa tarefa = new Tarefa();
		tarefa.setAgendaId(agendaId);
		tarefa.setDescricao(descricao);
		tarefaDAO.salvar(tarefa);

	}

	public List<Agenda> listarAgendas() throws SQLException {

		return agendaDAO.listar();

	}
}
