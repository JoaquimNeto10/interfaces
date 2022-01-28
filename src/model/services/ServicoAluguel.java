package model.services;

import model.entities.AluguelCarro;
import model.entities.Fatura;

public class ServicoAluguel {
	
	private Double precoPorDia, precoPorHora;
	
	private ImpostoServico impostoServico;
	
	public ServicoAluguel(){}

	public ServicoAluguel(Double precoPorDia, Double precoPorHora, ImpostoServico impostoBrasil) {
		super();
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.impostoServico = impostoBrasil;
	}
	
	public void faturaProcessada(AluguelCarro aluguelCarro) {
		long t1 = aluguelCarro.getInicio().getTime();//getTime pega o valor em milisegundos da data
		long t2 = aluguelCarro.getTermino().getTime();
		double horas = (double)(t2 - t1) / 1000 / 60 / 60;//cast double para poder pegar o valor quebrado e arredondar para cima.
		
		double pagamentoBasico;
		
		if(horas <= 12.0) {
			pagamentoBasico = Math.ceil(horas) * precoPorHora;
		} else {
			pagamentoBasico = Math.ceil(horas / 24) * precoPorDia;
		}
		
		double imposto = impostoServico.imposto(pagamentoBasico);
		
		aluguelCarro.setFatura(new Fatura(pagamentoBasico, imposto));
	}

	public Double getPrecoPorDia() {
		return precoPorDia;
	}

	public void setPrecoPorDia(Double precoPorDia) {
		this.precoPorDia = precoPorDia;
	}

	public Double getPrecoPorHora() {
		return precoPorHora;
	}

	public void setPrecoPorHora(Double precoPorHora) {
		this.precoPorHora = precoPorHora;
	}

	public ImpostoServico getImpostoBrasil() {
		return impostoServico;
	}

	public void setImpostoBrasil(ImpostoServico impostoServico) {
		this.impostoServico = impostoServico;
	}
}
