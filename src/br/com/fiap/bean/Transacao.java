package br.com.fiap.bean;

import java.sql.Date;
import java.util.Calendar;

public class Transacao {


	public int codigo;
	public double valor;
	public Date data;
	public Calendar dataTransacao;
	public int codigoGasto;
	public int codigoReceita;
	public int codigoInvestimento;
	public int codigoPessoa;
	public Transacao(int codigo2, double valor2, Calendar dataTransacao2, int codigoGasto2, int codigoReceita2,
												 int codigoInvestimento2, int codigoPessoa2) {
		// TODO Auto-generated constructor stub
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Calendar getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(Calendar dataTransacao) {
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
