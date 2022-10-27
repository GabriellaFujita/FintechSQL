package br.com.fiap.bean;

public class Receita {


	public int codigo;
	public String nome;
	public double valor;
	public String tipo;

	public Receita(int codigo, String nome, double valor, String tipo) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Receita{" +
				"codigo=" + codigo +
				", nome=" + nome +
				", valor=" + valor +
				", tipo=" + tipo +
				'}';
	}
}
