package br.unipe.funcionario.service;

import java.util.List;

import br.unipe.funcionario.domain.Funcionario;

public interface FuncionarioService {
	
	Funcionario save(Funcionario func);
	
	Funcionario getById(String id);
	
	List<Funcionario> listarFuncionarios();
	
	void delete(Funcionario func);

}
