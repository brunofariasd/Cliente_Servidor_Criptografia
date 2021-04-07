package clientes;

public class contaCorrente {

	private String cpf;
	private String nome;
	private String endereco;
	private String dataNascimento;
	private String telefone;	
	private int saldo;
	private int portaCliente;
	
	public contaCorrente(String cpf, String nome, String endereço, String dataNascimento, String telefone, int portaCliente) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setEndereco(endereço);
		this.setDataNascimento(dataNascimento);
		this.setTelefone(telefone); 
		this.saldo = 50;
		this.portaCliente = portaCliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getSaldo() {
		return saldo;
	}
	
	public void sacar(int valor) {
		if (valor <= this.saldo) {
			this.saldo -= valor;
		}
	}
	
	public void depositar(int valor) {
		if (valor > 0) {
			this.saldo += valor;
		}
	}
	
	public int saldo() {
		return getSaldo();
	}
	
}
