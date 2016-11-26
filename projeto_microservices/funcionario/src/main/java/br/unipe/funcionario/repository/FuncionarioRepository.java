package br.unipe.funcionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unipe.funcionario.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {
	
	public Funcionario findByName(String nome);

}
