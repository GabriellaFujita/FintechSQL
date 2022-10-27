package br.com.fiap.bean;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class Investimento {

	public int codigo;
	public String nome;
	public double valor;
	public String tipo;
	public double valorRendimento;
	public LocalDate data;
	public LocalDate dataDisponivel;


	public Investimento(int codigo, String nome, double valor, String tipo, double valorRendimento, LocalDate data, LocalDate dataDisponivel) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
		this.valorRendimento = valorRendimento;
		this.data = data;
		this.dataDisponivel = dataDisponivel;
	}

	public Investimento() {
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


	public double getValorRendimento() {
		return valorRendimento;
	}


	public void setValorRendimento(double valorRendimento) {
		this.valorRendimento = valorRendimento;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}


	public LocalDate getDataDisponivel() {
		return dataDisponivel;
	}

	public void setDataDisponivel(LocalDate dataDisponivel) {
		this.dataDisponivel = dataDisponivel;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Investimento{" +
				"codigo=" + codigo +
				", nome=" + nome +
				", valor=" + valor +
				", tipo=" + tipo +
				", valorRendimento=" + valorRendimento +
				", data=" + data +
				", dataDisponivel=" + dataDisponivel +
				'}';
	}
}
