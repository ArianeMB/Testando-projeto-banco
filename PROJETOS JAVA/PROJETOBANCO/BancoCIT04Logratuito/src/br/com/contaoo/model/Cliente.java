package br.com.contaoo.model;

public class Cliente {
	
	// couter é para contar e inicia do 1
		private static int counter = 1;
		
		private String nome;
		private String cpf;
		private String email;
		private String numerodetelefone;
		private String DDD;
		
		public Cliente(String nome, String cpf, String email,String DDD, String numerodetelefone) {
			this.nome = nome;
			this.cpf = cpf;
			this.email = email;
			this.DDD = DDD;
			this.numerodetelefone = numerodetelefone;
			
			counter += 1;
		}


		public static int getCounter() {
			return counter;
		}


		public String getNome() {
			return nome;
		}


		public String getCpf() {
			return cpf;
		}


		public String getEmail() {
			return email;
		}


		public static void setCounter(int counter) {
			Cliente.counter = counter;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public void setCpf(String cpf) {
			this.cpf = cpf;
		}


		public void setEmail(String email) {
			this.email = email;
		}


	

		public String getNumerodetelefone() {
			return numerodetelefone;
		}


		public void setNumerodetelefone(String numerodetelefone) {
			numerodetelefone = this.numerodetelefone;
		}
		
		public String toString() {
			return 
			" \nNome: " + this.getNome() + 
			" \nCPF: " + this.getCpf() +
			" \nE-mail: " + this.getEmail() +
			" \n DDD: " + this.getDDD() +
			" \nnumerodetefone: " + this.getNumerodetelefone();
			
		}


		public String getDDD() {
			return DDD;
		}


		public void setDDD(String dDD) {
			DDD = dDD;
		}
}
		


