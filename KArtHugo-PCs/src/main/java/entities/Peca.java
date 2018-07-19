package entities;

public class Peca {
	private String nome;
	private String categoria;
	private double preco;
	private int id;
	private static int cont = 0;
	// categorias: ram, hd, video etc

	public Peca(String nome, String categoria, double preco) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.id = cont++;
	}

	public String getNome() {
		return nome;
	}

	public Peca() {
		super();
		this.id = cont;

	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}