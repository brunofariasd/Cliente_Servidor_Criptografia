package clientes;

import java.util.Scanner;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class banco {
	
	private static List<contaCorrente> listaClientes = new ArrayList<>();
	private static Hashtable<String, String> loginclientes = new Hashtable<String, String>();
	private final static List<String> listaMetodos = List.of("autenticacao", "saque", "deposito", "saldo");

	public boolean autenticaCliente(String metodo, String nome, String cpf) {
		if (loginclientes.get(nome).equals(cpf)){
			return true;
		}return false;
	}

	public static String [] msgSeparada(String msg) {
		
		String [] arrayString = msg.split(":");
		return arrayString;
	}
	
	public static void main(String [] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		DatagramSocket socket = new DatagramSocket(666);
		
		
		System.out.print("Você ja possui conta no nosso Banco (y/n): ");
		String verificaConta = in.nextLine();
		if (verificaConta.equalsIgnoreCase("n")) {
			System.out.print("Quantas contas deseja criar: ");
			int n = in.nextInt();
			in.nextLine();
			for (int i = 0; i < n; i++) {
				System.out.print("\nDigite o seu CPF: ");
				String cpf = in.nextLine();
				System.out.print("Digite o seu Nome: ");
				String nome = in.nextLine();
				System.out.print("Digite o seu Endereço: ");
				String endereco = in.nextLine();
				System.out.print("Digite sua data de Nascimento: ");
				String dataNascimento = in.nextLine();
				System.out.print("Digite seu telefone: ");
				String telefone = in.nextLine();
				System.out.print("Digite a porta do Cliente: ");
				int portaCliente = in.nextInt();
				
				listaClientes.add(new contaCorrente(cpf, nome, endereco, dataNascimento, telefone, portaCliente));
				loginclientes.put(nome, cpf);
				System.out.println("Conta cadastrada com Sucesso!!!");
				System.out.println("Para realizar seu login utilize seu Nome e CPF, na aba do cliente!!!");
			}
			System.out.print("\nNumero de contas no Sistema: "+listaClientes.size());
		} else {
			System.out.println("Por favor realize seu Login na aba de Clientes!!!");
			while(true) {
				try {
					byte[] input = new byte[1024];
					byte[] output = new byte[1024];
					DatagramPacket inputPacket = new DatagramPacket(input, input.length);
					DatagramPacket outputPacket;

					socket.receive(inputPacket);
					String[] msgSeparada = msgSeparada(new String(inputPacket.getData()));
					
					
				}catch(IOException e) {
					System.err.println("Erro ao receber mensagem");
				}
			}
		}
		in.close();
	}
}
