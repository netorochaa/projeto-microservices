package br.unipe.funcionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unipe.funcionario.domain.EnumCargo;
import br.unipe.funcionario.domain.Funcionario;
import br.unipe.funcionario.hystrix.CargoBean;
import br.unipe.funcionario.service.FuncionarioService;

@RestController
public class FuncionarioController {
	
	private final FuncionarioService funcService;
	
	@Autowired
	private CargoBean cargoBean;
	
	@Autowired
	public FuncionarioController(final FuncionarioService funcService) {
		this.funcService = funcService;
	}

	@RequestMapping(value="/funcionario", method = RequestMethod.GET)
	public ResponseEntity< List<Funcionario> > listarFuncionarios() {
		
		return new ResponseEntity<List<Funcionario>>(
				funcService.listarFuncionarios(), HttpStatus.OK);
		
	}

	@RequestMapping(value = "/funcionario/{id}",method = RequestMethod.GET)
	public ResponseEntity<String> getFuncionario(@PathVariable String id) {
		
		Funcionario funcionario = funcService.getById(id);
		
		String retorno = null;
		
		if(funcionario != null){
			retorno = funcionario.toString();
			retorno += " / " + cargoBean.getCargo(funcionario.getCargo()).toString();
		}
		
		return funcionario == null ? 
				new ResponseEntity<String>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<String>(retorno, HttpStatus.OK);
	}
	
	@RequestMapping(value="/funcionario", method = RequestMethod.POST)
	public ResponseEntity<String> createFuncionario(@RequestBody Funcionario funcionario) {

		try {
			
			if(funcionario.getCargo() == null || funcionario.getCargo().equals("")){
				return new ResponseEntity<String>(EnumCargo.getMessageError(), 
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			funcionario.setCargo(EnumCargo.valueOf(funcionario.getCargo().toUpperCase()).getCargo());
		
			funcService.save(funcionario);
			return new ResponseEntity<String>(HttpStatus.CREATED);	

		}catch(IllegalArgumentException e){
			e.printStackTrace();
			return new ResponseEntity<String>(EnumCargo.getMessageError(), 
					HttpStatus.INTERNAL_SERVER_ERROR);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/funcionario/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Funcionario> delete(@PathVariable String id) {
		
		Funcionario funcEncontrado = funcService.getById(id);
		
		if(funcEncontrado == null) {
			return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
		}
		
		funcService.delete(funcEncontrado);
		
		return new ResponseEntity<Funcionario>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/funcionario/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Funcionario> update(@PathVariable String id, 
			@RequestBody Funcionario func) {
		
		Funcionario funcEncontrado = funcService.getById(id);
		
		if(funcEncontrado == null) {
			return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
		}
		
		func.setId(id);
		funcService.save(func);
		
		return new ResponseEntity<Funcionario>(HttpStatus.OK);
	}

	public FuncionarioService getFuncService() {
		return funcService;
	}
	
	
}
