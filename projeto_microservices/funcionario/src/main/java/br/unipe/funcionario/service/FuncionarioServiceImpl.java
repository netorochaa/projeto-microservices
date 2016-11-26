package br.unipe.funcionario.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.unipe.funcionario.domain.Funcionario;
import br.unipe.funcionario.repository.FuncionarioRepository;

@Service
@Validated
public class FuncionarioServiceImpl implements FuncionarioService {
	
	private final FuncionarioRepository repository;
	
	@Autowired
	public FuncionarioServiceImpl(final FuncionarioRepository repository) {
		this.repository = repository;
	}

	@Transactional
	@Override
	public Funcionario save(@NotNull @Valid final Funcionario func) {
		return repository.save(func);
	}

	@Override
	public Funcionario getById(String id) {
		return repository.findOne(id);
	}

	@Override
	public List<Funcionario> listarFuncionarios() {
		return repository.findAll();
	}

	@Override
	public void delete(Funcionario func) {
		repository.delete(func);
	}

}
