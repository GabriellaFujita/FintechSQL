package br.com.fiap.bean;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class Meta {


	public int codigo;
	public int codigoPessoa;
	public String nome;
	public LocalDate data1;
	public LocalDate dataCriacao;
	public LocalDate dataFinal;
	public double valor;

	public Meta(int codigo, int codigoPessoa, String nome, LocalDate data1, LocalDate dataCriacao, LocalDate dataFinal, double valor) {
		this.codigo = codigo;
		this.codigoPessoa = codigoPessoa;
		this.nome = nome;
		this.data1 = data1;
		this.dataCriacao = dataCriacao;
		this.dataFinal = dataFinal;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData1() {
		return data1;
	}

	public void setData1(LocalDate data1) {
		this.data1 = data1;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Meta{" +
				"codigo=" + codigo +
				", codigoPessoa=" + codigoPessoa +
				", nome=" + nome +
				", data1=" + data1 +
				", dataCriacao=" + dataCriacao +
				", dataFinal=" + dataFinal +
				", valor=" + valor +
				'}';
	}
}
