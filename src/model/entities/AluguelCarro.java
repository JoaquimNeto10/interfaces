package model.entities;

import java.util.Date;

public class AluguelCarro {
	
	private Date inicio, termino;
	
	private Veiculos veiculos;
	private Fatura fatura;
	
	public AluguelCarro() {}

	public AluguelCarro(Date inicio, Date termino, Veiculos veiculos) {
		this.inicio = inicio;
		this.termino = termino;
		this.veiculos = veiculos;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public Veiculos getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(Veiculos veiculos) {
		this.veiculos = veiculos;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
}
