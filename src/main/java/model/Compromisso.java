package main.java.model;

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

	public int getId() {
		return id;
	}

	public String getData() {
		return data;
	}

	public String getHora() {
		return hora;
	}

	public String getDescricao() {
		return descricao;
	}
}
