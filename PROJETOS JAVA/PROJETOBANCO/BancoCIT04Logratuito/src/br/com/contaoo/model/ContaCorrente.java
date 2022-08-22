package br.com.contaoo.model;



public class ContaCorrente extends Conta {
	
	public ContaCorrente(Cliente cliente) {
		super(cliente);
		
	}

	private Double saldo = 0.00;
	
	//Método que retorna o rendimento
	
	public double rendimento() {
		
		double rendimentofinal = 0.00;
		rendimentofinal = getSaldo()* 0.05;
		return rendimentofinal;
		
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
