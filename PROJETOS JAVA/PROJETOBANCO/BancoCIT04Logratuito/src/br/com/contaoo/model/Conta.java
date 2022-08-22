package br.com.contaoo.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conta  {
	
	private static int contadorDeContas = 4000;
	
	private String tipoconta;
	private String datadeabertura;
	private double taxa;
	private double saldo = 0.00;
	private int numeroAgência = 0001;
	private int numeroConta;
	private Cliente cliente;//Fiz um import da classe Cliente
	
	

		// retirou int numeroConta e retirou , Double saldo
		public Conta(Cliente cliente) {
			//alterei de numeroConta para contadorDeContas
			//pois sempre que for criar uma conta vai contar
			
			contadorDeContas +=1;
			this.numeroConta = contadorDeContas; 
			this.cliente = cliente;
			//this.saldo = saldo;//retirou
			
		}
	
	

	public Conta() {
		
	}


	public String getTipoconta() {
		return tipoconta;
	}


	

	public String getDatadeabertura() {
		return datadeabertura;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setTipoconta(String tipoconta) {
		this.tipoconta = tipoconta;
	}


	

	public void setDatadeabertura(String datadeabertura) {
		this.datadeabertura = datadeabertura;
	}





	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	
	public double getTaxa() {
		return taxa;
	}


	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}


	public int getNumeroAgência() {
		return numeroAgência;
	}


	public void setNumeroAgência(int numeroAgência) {
		this.numeroAgência = numeroAgência;
	}


	public int getNumeroConta() {
		return numeroConta;
	}


	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	// Estanciando o saldo para refletir nos dados da conta:
	
	
	 //ContaPoucanca cp = new ContaPoucanca();
	 //cp.getSaldoparadeposito();
	

	public String toString() {
		return 
		"===========================================================================" +	
		   " \n Número da Agência: 000 " + this.getNumeroAgência() +	
		   " \n Número da conta: " + this.getNumeroConta() + 
		   " \n Nome do cliente: " + this.cliente.getNome() + 
		   " \n CPF: " + this.cliente.getCpf() +
		   " \n Email: " + this.cliente.getEmail() +
		   " \n Numero de telefone: " +  "(" + this.cliente.getDDD() + ") " + this.cliente.getNumerodetelefone() +
		   " \n Saldo : R$ " + this.saldo +   "\n" +
		"===========================================================================";
	}	
	

	public String sacar ( double valor) {
		
		if( valor >= saldo) {
			saldo = saldo - valor;
			return " Saque realizado";
		}else {
			return " Saldo insuficiente";
		}
			
		}
	
		///Método de formatação da data atualizada no momento de depositar
	
	Date data = new Date();
	SimpleDateFormat formatar = new SimpleDateFormat(" dd/MM/yyyy");
	String dataFormatada = formatar.format(data);
	
//	///////TESTANDO
//     ContaPoucanca cp = new ContaPoucanca();

	 	 
	
		//Método depositar:	
		public void depositar(Double valor) {
			if (valor > 0) {
				setSaldo(getSaldo() + valor );
				System.out.println(" Depósito  foi realizado na data "  + dataFormatada );
			}else {
				System.out.println(" Não foi possível realizar o depósito! ");
			}
	}
		// MÉTODO SALDO
		
		public void saldo() {
					
			System.out.println(" Seu saldo é de: R$  " + this.saldo);
			
			return;
}
}
