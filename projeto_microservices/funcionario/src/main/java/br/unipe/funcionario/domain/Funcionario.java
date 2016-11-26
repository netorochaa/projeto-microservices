package br.unipe.funcionario.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Funcionario implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
	@Id
	private String id;
	private String name;
	private String cargo;
	
	public Funcionario() {
	}

	

	public Funcionario(String id, String name, String cargo) {
		super();
		this.id = id;
		this.name = name;
		this.cargo = cargo;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getCargo() {
		return cargo;
	}


	@Override
	public String toString() {
		return "Funcionário [id=" + this.id + "; nome=" + this.name + "; cargo=" + this.cargo + "]";
	}

}
