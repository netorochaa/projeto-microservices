package br.unipe.cargo.domain;

import java.io.Serializable;
public class Cargo implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
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
		return "Informação Cargo[Nome: " + this.nome + "; Responsabilidade: " + this.responsabilidade
				+ "; Salário R$" + this.salario + "]";
	}

}
