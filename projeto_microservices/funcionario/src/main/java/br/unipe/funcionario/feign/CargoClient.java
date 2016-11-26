package br.unipe.funcionario.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unipe.funcionario.domain.Cargo;

@FeignClient("cargo")
public interface CargoClient {

	@RequestMapping(method = RequestMethod.GET, value = "/cargo/{nome}")
	Cargo getCargo(@PathVariable("nome") String nome);
}
