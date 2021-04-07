package clientes;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class cliente {

	private final static List<String> listaMetodos = List.of("autenticacao", "saque", "deposito", "saldo");
	
	public static String msgUnificada(List<String> msgSeparada) {
		
		String msgUnificada = "";
		Iterator<String> i = msgSeparada.iterator();		
		while(i.hasNext()) {
			msgUnificada = msgUnificada+":"+i.next();
		}
		
		return msgUnificada+":";
	}

	public static void main(String [] args) throws UnknownHostException {
		
		try (Scanner in = new Scanner(System.in)) {
			List<String> msgs = new ArrayList<String>();
			byte[] output = new byte[1024];
			DatagramPacket packet;
			
			System.out.println("Olá bem vindo ao banco BadUser666!!!");
			System.out.println("Para conseguir realizar operações sobre a sua conta, siga com os passos da autenticação !");
			
			System.out.print("Digite seu nome: ");
			String nome = in.nextLine();
			System.out.print("Digite sua senha (CPF): ");
			String cpf = in.nextLine();
			
			msgs.add(nome);
			msgs.add(cpf.replaceAll("[^0-9]", ""));
			
			String msg = msgUnificada(msgs);
			
			output = msg.getBytes();
			packet = new DatagramPacket(output, output.length, InetAddress.getLocalHost(), 666);
		}
		
	}
}
