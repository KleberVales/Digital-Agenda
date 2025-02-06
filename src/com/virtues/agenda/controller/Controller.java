package com.virtues.agenda.controller;

import java.util.List;

import com.virtues.agenda.dao.CompromissoDAO;
import com.virtues.agenda.model.Compromisso;

public class Controller {
	private CompromissoDAO dao;
	
	public Controller() {
		dao = new CompromissoDAO();
	}
	

	public void controllerSalvar(String data, String hora, String descricao) {
		
		dao.salvarCompromisso(new Compromisso(0, data, hora, descricao ));
		
	}


	public List<Compromisso> obterCompromisso() {

		return dao.listarCompromisso();
	}


	public void deletarCompromisso(int id) {
		
		dao.remover(id);
		
	}

}
