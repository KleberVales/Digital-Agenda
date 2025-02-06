package com.virtues.agenda.model;

public class Compromisso {
	
	private int id;
	private String data;
	private String hora;
	private String descricao;

	public Compromisso(int id, String data, String hora, String descricao) {
		
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.descricao = descricao;
		
	}
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}


	public String getData() {
		// TODO Auto-generated method stub
		return data;
	}

	public String getHora() {
		// TODO Auto-generated method stub
		return hora;
	}

	public String getDescricao() {
		// TODO Auto-generated method stub
		return descricao;
	}

}
