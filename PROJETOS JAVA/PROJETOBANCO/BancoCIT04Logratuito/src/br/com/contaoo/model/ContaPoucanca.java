package br.com.contaoo.model;

// Taxa = o;
//Para conta poupanca necessário incluir 30,00 no momento da abertura

public class ContaPoucanca extends Conta {
	
	private Cliente cliente;

	public double taxa;
	private int numeroConta;
	private static int contadorDeContas = 5000;
	public double saldoparadeposito = 30.00;
	
		
    // sobrecarga de método, é criar uma class já passando um cliente
	public ContaPoucanca(Cliente cliente) {
		//alterei de numeroConta para contadorDeContas
		//pois sempre que for criar uma conta vai contar
				
		this.cliente = cliente;
		this.taxa = taxa;
		contadorDeContas +=1;
		numeroConta = contadorDeContas; 
		this.saldoparadeposito = 30.00;
		
		//this.saldo = saldo;//retirou
		
	}
	
	
	public int getNumeroConta() {
		return numeroConta;
	}


	public static int getContadorDeContas() {
		return contadorDeContas;
	}


	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}


	public static void setContadorDeContas(int contadorDeContas) {
		ContaPoucanca.contadorDeContas = contadorDeContas;
	}


	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public double getTaxa() {
		return taxa;
	}
	public double getSaldoparadeposito() {
		return saldoparadeposito;
	}
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
	public void setSaldoparadeposito(double saldoparadeposito) {
		this.saldoparadeposito = saldoparadeposito;
	}
	
	// Método do rendimento
	
	   public double CalcularRendimento() {

	        double rendimentoAoMes = (0.05 * getSaldoparadeposito());

	        return rendimentoAoMes;
	    }
	   
	   
//	public double setSaldo() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//		
	}
	

