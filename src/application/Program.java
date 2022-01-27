package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.AluguelCarro;
import model.entities.Veiculos;
import model.services.ImpostoBrasil;
import model.services.ServicoAluguel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Entre com os dados do aluguel:");
		System.out.print("Modelo do carro: ");
		String modeloCarro = sc.nextLine();
		System.out.print("Ida (dd/MM/yyyy hh:ss): ");
		Date ida = sdf.parse(sc.nextLine());
		System.out.print("Volta (dd/MM/yyyy hh:ss): ");
		Date volta = sdf.parse(sc.nextLine());
		
		AluguelCarro ac = new AluguelCarro(ida, volta, new Veiculos(modeloCarro));
		
		System.out.print("Digite o preço por hora: ");
		double precoPorHora = sc.nextDouble();
		System.out.print("Digite o preço por dia: ");
		double precoPorDia = sc.nextDouble();
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(precoPorDia, precoPorHora, new ImpostoBrasil());
		
		servicoAluguel.faturaProcessada(ac);
		
		System.out.println();
		System.out.println("FATURA");
		System.out.println("Pagamento básico: " + String.format("%.2f", ac.getFatura().getPagamentoBasico()));
		System.out.println("Imposto: " + String.format("%.2f", ac.getFatura().getImposto()));
		System.out.println("Pagamento total: " + String.format("%.2f", ac.getFatura().pagamentoTotal()));		
		
		sc.close();

	}

}
