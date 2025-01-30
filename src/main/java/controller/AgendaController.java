package main.java.controller;

import main.java.dao.CompromissoDAO;
import main.java.model.Compromisso;
import java.util.List;

public class AgendaController {
    private CompromissoDAO dao;

    public AgendaController() {
        this.dao = new CompromissoDAO();
    }

    public void adicionarCompromisso(String data, String hora, String descricao) {
        dao.salvarCompromisso(new Compromisso(0, data, hora, descricao));
    }

    public List<Compromisso> obterCompromissos() {
        return dao.listarCompromissos();
    }

    public void removerCompromisso(int id) {
        dao.excluirCompromisso(id);
    }
}
