package br.unipe.funcionario.domain;

public class Cargo {
	
	private String nome;
	private double salario;
	private String responsabilidade;
	
	

	public Cargo(String nome, double salario, String responsabilidade) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.responsabilidade = responsabilidade;
	}
	
	@Override
	public String toString() {
		return "Cargo: " + this.nome + " Responsabilidade: " + this.responsabilidade
				+ " Salário R$" + this.salario;
	}

}
