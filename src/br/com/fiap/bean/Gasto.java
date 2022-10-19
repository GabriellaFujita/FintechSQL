package br.com.fiap.bean;

public class Gasto {

public int codigo;
public String nome;
public double valor;
public String tipo;


public Gasto(int codigo2, String nome2, double valor2, String tipo2) {
		// TODO Auto-generated constructor stub
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

}
