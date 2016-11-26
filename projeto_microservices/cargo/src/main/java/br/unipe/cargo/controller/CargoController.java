package br.unipe.cargo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unipe.cargo.domain.Cargo;

@RestController
public class CargoController {
	
	private static final Map<String, Cargo> CARGOS = new HashMap<String, Cargo>();
	
	static {
		CARGOS.put("PROGRAMADOR", new Cargo("PROGRAMADOR", 3500, 
				"Garantir que a manutenção e criação dos aplicativos estejam em perfeitas "
				+ "condições de uso, bem como dentro de prazos, qualidade e custos"));
		CARGOS.put("ANALISTA", new Cargo("ANALISTA", 5500, 
				"Garantir que o produto desenvolvido esteja de acordo com as especificações "
				+ "definidas pelo cliente e empresa."));
		CARGOS.put("GERENTE", new Cargo("GERENTE", 10000, 
				"Gerir o cronograma geral, garantindo que o trabalho é atribuído aos "
				+ "recursos adequados e concluído no prazo e dentro do orçamento."));
	}

	@RequestMapping(value="/cargo/{nome}", method = RequestMethod.GET)
	public Cargo getCargo(@PathVariable String nome) {
		
		return CARGOS.get(nome.toUpperCase());
		
	}

	
}
