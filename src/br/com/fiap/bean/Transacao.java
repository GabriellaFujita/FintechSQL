package br.com.fiap.bean;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Transacao {


	public int codigo;
	public double valor;
	public LocalDate data;
	public LocalDateTime dataTransacao;
	public int codigoGasto;
	public int codigoReceita;
	public int codigoInvestimento;
	public int codigoPessoa;

	public Transacao(int codigo, double valor, LocalDate data, LocalDateTime dataTransacao, int codigoGasto, int codigoReceita, int codigoInvestimento, int codigoPessoa) {
		this.codigo = codigo;
		this.valor = valor;
		this.data = data;
		this.dataTransacao = dataTransacao;
		this.codigoGasto = codigoGasto;
		this.codigoReceita = codigoReceita;
		this.codigoInvestimento = codigoInvestimento;
		this.codigoPessoa = codigoPessoa;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalDateTime getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(LocalDateTime dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	public int getCodigoGasto() {
		return codigoGasto;
	}
	public void setCodigoGasto(int codigoGasto) {
		this.codigoGasto = codigoGasto;
	}
	public int getCodigoReceita() {
		return codigoReceita;
	}
	public void setCodigoReceita(int codigoReceita) {
		this.codigoReceita = codigoReceita;
	}
	public int getCodigoInvestimento() {
		return codigoInvestimento;
	}
	public void setCodigoInvestimento(int codigoInvestimento) {
		this.codigoInvestimento = codigoInvestimento;
	}
	public int getCodigoPessoa() {
		return codigoPessoa;
	}
	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Transacao{" +
				"codigo=" + codigo +
				", valor=" + valor +
				", data=" + data +
				", dataTransacao=" + dataTransacao +
				", codigoGasto=" + codigoGasto +
				", codigoReceita=" + codigoReceita +
				", codigoInvestimento=" + codigoInvestimento +
				", codigoPessoa=" + codigoPessoa +
				'}';
	}
}
