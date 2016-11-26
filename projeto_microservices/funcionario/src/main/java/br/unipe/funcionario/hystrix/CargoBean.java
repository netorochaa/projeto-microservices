package br.unipe.funcionario.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.unipe.funcionario.domain.Cargo;
import br.unipe.funcionario.feign.CargoClient;

@Component
public class CargoBean {

	@Autowired
	private CargoClient cargoClient;

	@HystrixCommand(fallbackMethod = "cacheCargo")
	public Cargo getCargo(String nome) {
		return cargoClient.getCargo(nome);
	}

	public Cargo cacheCargo(String nome) {
		return new Cargo(nome, 0, null );
	}
}
