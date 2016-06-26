package br.com.brunoluz.breeweer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.brunoluz.breeweer.model.Cerveja;


@Controller
public class CervejaController {
	
	
	@RequestMapping(value = { "/cervejas/novo" })
	public String novo() {
		return "cervejas/cadastro-cerveja";
	}
	
	
	@RequestMapping(value = { "/cervejas/novo" }, method = RequestMethod.POST)
	public String cadastrar(Cerveja cerveja) {
		
		System.out.println(">>> Cadastrar Cerveja : " + cerveja.getSku());
		System.out.println(">>> Cadastrar Cerveja : " + cerveja.getNome());
		return "cervejas/cadastro-cerveja";
		
	}
	
	
}