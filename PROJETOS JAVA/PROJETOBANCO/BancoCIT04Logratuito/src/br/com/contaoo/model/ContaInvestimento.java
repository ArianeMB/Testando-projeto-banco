package br.com.contaoo.model;

// Taxa de 27,00 fixo
// Não é necessário investir nenhum valor no momento da abertura

public class ContaInvestimento extends Conta {

	double taxa = 27.00;
	double saldo;
	
	
		
	
	public ContaInvestimento(Cliente cliente, double taxa, double saldo) {
		super(cliente);
		this.taxa = taxa;
		this.saldo = saldo;
	}


	public double getTaxa() {
		return taxa;
	}


	public double getSaldo() {
		return saldo;
	}





	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}





	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}





	public ContaInvestimento(Cliente cliente) {
		super(cliente);
		
	}


	public ContaInvestimento() {
		// TODO Auto-generated constructor stub
	}



	
		
	}


