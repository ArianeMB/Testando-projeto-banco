import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import br.com.contaoo.model.Cliente;
import br.com.contaoo.model.Conta;
import br.com.contaoo.model.ContaCorrente;
import br.com.contaoo.model.ContaInvestimento;
import br.com.contaoo.model.ContaPoucanca;

public class TesteWendel {

// Chamei minha lista de arrylist de contasBancarias
   static ArrayList<Conta> contasBancarias;
   static ArrayList<ContaPoucanca> contasPoupanca;

   static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		// static é atributo de classe, informação de que todos objetos da classe
		// consigam ver a informação.

		int operação;
		
		
		ContaInvestimento ci = null;
		ContaCorrente cc = null;
		//public Double valorDepositado;

       	contasBancarias = new ArrayList<Conta>();
       	contasPoupanca = new ArrayList<ContaPoucanca>();


     // Criando menu de operaçoes
     		operacoes();
	}

     	@SuppressWarnings("unused")
     	public static void operacoes() {


		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat(" dd/MM/yyyy");
		String dataFormatada = formatar.format(data);

		System.out.println(" ");
		System.out.println(" --------------------------------------------------");
		System.out.println(" -------------- Extrato Bancário-------------------");
		System.out.println(" --------------------------------------------------");
		System.out.println(" ----------------Banco CI&T Versão 2.0-------------");
		System.out.println(" --------------------------------------------------");
		System.out.println(" ------- Data de hoje: " + dataFormatada + "--------");
		System.out.println(" --------------------------------------------------");
		System.out.println(" *** Selecione uma operação que deseja realizar ***");
		System.out.println(" --------------------------------------------------");
		System.out.println("         |    Opção 1 - Criar conta      |         ");
		System.out.println("         |    Opção 2 - Depositar        |         ");
		System.out.println("         |    Opção 3 - Sacar            |         ");
		System.out.println("         |    Opção 4 - Transferir       |         ");
		System.out.println("         |    Opção 5 - Listar           |         ");
		System.out.println("         |    Opção 6 - Saldo            |         "); // incluí a opção saldo
		System.out.println("         |    Opção 7 - Rendimento       |         ");
		System.out.println("         |    Opção 8 - Sair             |         ");
		System.out.println(" ");
		System.out.println(" ");

		int operacao = leia.nextInt();
		// Incluir rendimento diário, mensal, anual ,

		switch (operacao) {
		case 1:
			criarConta(dataFormatada);
			break;
		case 2:
			depositar();
			break;
//		case 3:
//			sacar();
//			break;
//		case 4:
//			transferir();
//			break;
//		case 5:
//			listar(); /// Realizar dois métodos, procurar por número da conta ou CPF
//			break;
//		case 6:
//			saldo();
//			break;
//		case 7:
//			rendimento();
//			break;
		case 8:
			System.out.println(" Obrigado por ser nosso correntista," + " o Banco CI&T agradece sua preferência!! ");
			System.exit(0);// Determina que o programa está saindo com sucesso
			defaut: // Direcionar a mensagem diferente do que está sendo pedito.
			System.out.println(" Opcão inválida !!!!");
			operacoes();// chamou o menu principal pois não quer sair, dar opção do menu

		}

	}

	

   // Método Criar Conta

	public static void criarConta(String taxa) {
	
		int opcaoConta; //opção de conta
				

		System.out.print(" Nome do cliente: ");
		String nome = leia.next();

		System.out.print(" CPF: ");
		String cpf = leia.next();

		System.out.print(" E-mail: ");
		String email = leia.next();
		
		System.out.print(" Numero de DDD:  ");
		String DDD = leia.next();
		
		
		System.out.print(" Numero de Telefone:  ");
		String numerodetelefone = leia.next();
	//	\\System.out.print("\n(" + DDD.getDDD() + ") " + Numero.getNumero());
		
		System.out.println("");
		System.out.println("");	
		
		Cliente cliente = new Cliente(nome, cpf, email,DDD,numerodetelefone);
		
		
		 System.out.println("    Qual tipo de conta deseja criar ?       ");
		 System.out.println(" =================================>>>       ");
		 System.out.println("<< Opção 1 - Conta Poupança               >>");
		 System.out.println("<< Opção 2 - Conta Investimento           >>");
		 System.out.println("<< Opção 3 - Conta Corrente               >>");
		 System.out.println("<< Opção 4 - Retorno para menu de opções. >>");
		 System.out.println("<< Opção 5-  Sair                         >>");
		 System.out.println(" ===========================================");
		 opcaoConta = leia.nextInt();
		 
		
		 switch (opcaoConta) {
			case 1: ///Conta Poupança
				
				ContaPoucanca contaPoupanca = new ContaPoucanca(cliente);
				
					
					System.out.print(" Qual valor você irá depositar para abrir sua conta? R$ ");
					double valorDepositado = leia.nextDouble();
					contaPoupanca.depositar(valorDepositado); ///// FAGNER
					contasPoupanca.add(contaPoupanca); //////// FAGNER
					 
					//contasBancarias.add(cp); //////// FAGNER
					              
					if( valorDepositado >=  contaPoupanca.getSaldoparadeposito()) {
						System.out.println(" R$ " + String.format(" %.2f" ,valorDepositado) + " Depositado e Conta Poupança Criada com sucesso!!");
						System.out.println(" ");
						
						System.out.println(" Segue abaixo dados de sua conta criada: ");
						
						if (contasPoupanca.size() > 0) {
							
							for(ContaPoucanca conta: contasPoupanca){
								
								String retorno =  ListarDadosConta(
										conta.getNumeroAgência(), 
										conta.getNumeroConta(),
										conta.getCliente().getNome(),
										conta.getCliente().getCpf(),
										conta.getCliente().getEmail(),
										conta.getCliente().getDDD(),
										conta.getCliente().getNumerodetelefone(),
										conta.getSaldo());
								
								System.out.println(retorno);
							}
								
							
						} else {
								System.out.println("Não há contas cadastradas");
								
						}
					}else {
						System.out.println( String.format(" %.2f" ,valorDepositado) + " Não é suficiente para abrir a sua Conta Poupança, "
								+ " gentileza depositar o valor mínimo de R$ " +  String.format(" %.2f" , contaPoupanca.getSaldoparadeposito()) + " . ");
						System.out.println(" ");
					}
					System.out.println(" Deseja voltar para o menu de operações ou sair?  ");
					System.out.println(" ");
					System.out.println(" 1 - Menu de Operações");
					System.out.println(" 2 - Sair ");
					System.out.println(" ");
					double escolha = leia.nextDouble();
					
					if (escolha == 1 ) {
						operacoes();
					}else {
					System.out.println(" Obrigado por ser nosso correntista," + " o Banco CI&T agradece sua preferência!! ");
					System.exit(0);//Determina que o programa está saindo com sucesso
					}
							
								break;
					/////CONTA INVESTIMENTO			
			case 2:
						System.out.println(" Sua Conta Investimento foi criada com sucesso,"
						+ " não esqueça de depositar o valor da taxa mensal de: R$ 27,00");
						System.out.println(" ");
						
						System.out.println(" Segue abaixo dados de sua Conta Investimento criada: ");
						
						Conta contaInvestimento = new Conta(cliente);
						contasBancarias.add(contaInvestimento); 
						
						if (contasBancarias.size() > 0) {
							
							for(Conta conta: contasBancarias){
								
								String retorno =  ListarDadosConta(
										conta.getNumeroAgência(), 
										conta.getNumeroConta(),
										conta.getCliente().getNome(),
										conta.getCliente().getCpf(),
										conta.getCliente().getEmail(),
										conta.getCliente().getDDD(),
										conta.getCliente().getNumerodetelefone(),
										conta.getSaldo());
								
								System.out.println(retorno);
							}
							
						} else {
								System.out.println("Não há contas cadastradas");
								
						}
							
						System.out.println(" ");
						System.out.println(" Deseja voltar para o menu de operações ou sair?  ");
						System.out.println(" ");
						System.out.println(" 1 - Menu de Operações");
						System.out.println(" 2 - Sair ");
						System.out.println(" ");
						double escolha2 = leia.nextDouble();
						
						if (escolha2 == 1 ) {
							operacoes();
						}else {
						System.out.println(" Obrigado por ser nosso correntista," + " o Banco CI&T agradece sua preferência!! ");
						System.exit(0);//Determina que o programa está saindo com sucesso
						
						}
							
				break;
				
				///CONTA CORRENTE
			case 3:
				//cc();
				System.out.println(" Sua Conta Corrente foi criada com sucesso, parabéns !!" );
				System.out.println(" ");
				System.out.println(" Segue abaixo dados de sua Conta Corrente: " );
				
				Conta contaCorrente = new Conta(cliente);
				contasBancarias.add(contaCorrente); 
				
				if (contasBancarias.size() > 0) {
					
					for(Conta conta: contasBancarias){
						
						String retorno =  ListarDadosConta(
								conta.getNumeroAgência(), 
								conta.getNumeroConta(),
								conta.getCliente().getNome(),
								conta.getCliente().getCpf(),
								conta.getCliente().getEmail(),
								conta.getCliente().getDDD(),
								conta.getCliente().getNumerodetelefone(),
								conta.getSaldo());
						
						System.out.println(retorno);
					}
					
				} else {
						System.out.println("Não há contas cadastradas");
						
				}
			
			System.out.println(" ");
			System.out.println(" Deseja voltar para o menu de operações ou sair?  ");
			System.out.println(" ");
			System.out.println(" 1 - Menu de Operações");
			System.out.println(" 2 - Sair ");
			System.out.println(" ");
			double escolha3 = leia.nextDouble();
			
			if (escolha3 == 1 ) {
				operacoes();
			}else {
			System.out.println(" Obrigado por ser nosso correntista," + " o Banco CI&T agradece sua preferência!! ");
			System.exit(0);//Determina que o programa está saindo com sucesso
			
			}
				
				operacoes();
				
				break;
			case 4: // Retornar para menu de operações
				
				System.out.println(" Retornarndo para o menu de operações.....");
				operacoes();		
							
			case 5:
				//cc();
				System.out.println(" Obrigado por ser nosso correntista," + " o Banco CI&T agradece sua preferência!! ");
				System.exit(0);//Determina que o programa está saindo com sucesso
				defaut: // Direcionar a mensagem diferente do que está sendo pedito.
				System.out.println(" Opcão inválida !!!!");
				
		 }
	}



		// MÉTODO DEPOSITAR
		
		public  static void depositar() {
			
			System.out.print(" Qual o número da conta você deseja depositar: ");
			int numeroConta = leia.nextInt();
			
			// Faz a busca e olha para encontrar
			Conta conta = encontrarConta(numeroConta);
			
			// Fazer validações se a conta irá encontrar
			if (conta != null) { //A conta tem que ser diferente de nulo, 
				System.out.print(" Qual valor deseja depositar? R$ ");
				
				Double valorDeposito = leia.nextDouble();
			/////OBSERVEI QUE FOI POSSÍVEL CHAMAR O MÉTODO depositar que está na class Conta
				conta.depositar(valorDeposito); 
				
				System.out.print(" Valor R$  " + valorDeposito + " depositado com sucesso! ");
			} else {
				System.out.print(" Conta " + numeroConta + " não encontrada! ");
				System.out.println(" ");
				
			}////////////////////  FALTA FAZER O DEMONSTRATIVO DE DADOS DA CONTA
			
			System.out.println(" Segue abaixo dados de sua conta " + numeroConta + " com saldo atualizado: ");
			
			if (contasBancarias.size() > 0) {
				
			for(Conta conta1: contasBancarias){
					System.out.println(conta1);
				}
				
			} else {
					System.out.println("Não há contas cadastradas");
					
			}
						
			
			/////////////////////////	
		System.out.println(" ");
		System.out.println(" Deseja voltar para o menu de operações ou sair?  ");
		System.out.println(" ");
		System.out.println(" 1 - Menu de Operações");
		System.out.println(" 2 - Sair ");
		System.out.println(" ");
		double escolha2 = leia.nextDouble();
		
		if (escolha2 == 1 ) {
			operacoes();
		}else {
		System.out.println(" Obrigado por ser nosso correntista," + " o Banco CI&T agradece sua preferência!! ");
		System.exit(0);//Determina que o programa está saindo com sucesso
		
		}
		
			operacoes();// Para retornar ao menu de opções
		
		}
	

		
		/////MÉTODO ENCONTRAR CONTA:
		
		private static Conta encontrarConta(int numeroConta) {
			
			Conta conta = null;
			// Definiu como null porque se a conta NÃO existir irá retornar
			// e vai dizer conta não encontrada
			if (contasBancarias.size() > 0 ) { //// OLHANDO AQUI 
				// Para cada conta dentro de contasbancarias
				for (Conta c : contasBancarias) {
					if (c.getNumeroConta() == numeroConta) {
						// Se a conta c criada dentro da conta
					    // bancária for igual ao número de conta que o usuário digitou
					    // a minha conta irá receber a conta c
					   conta = c;
					   break;
					}
				}
			}
			return conta;
		
		}
		
		
		public static String ListarDadosConta(int agencia, int numeroConta, String nomeCliente, String cpfCliente, String email, String ddd, String telefone, double saldo ) {
			
			return 
			"===========================================================================" +	
			   " \n Número da Agência: 000 " + agencia +	
			   " \n Número da conta: " + numeroConta + 
			   " \n Nome do cliente: " + nomeCliente + 
			   " \n CPF: " + cpfCliente +
			   " \n Email: " + email +
			   " \n Numero de telefone: " +  "(" + ddd + ") " + telefone +
			   " \n Saldo : R$ " + saldo +   "\n" +
			"===========================================================================";
			
		}		

}