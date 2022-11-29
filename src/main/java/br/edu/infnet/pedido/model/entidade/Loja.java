package br.edu.infnet.pedido.model.entidade;

public class Loja {
	private Long codigo;
	private String nome;

	public Loja() {
	}

	public Loja(String nome) {
		super();
		this.nome = nome;
	}

	public Loja(String nome, Long codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Loja [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
