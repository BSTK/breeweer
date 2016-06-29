package br.com.brunoluz.breeweer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.brunoluz.breeweer.model.Cidade;


@Controller
public class CidadeController {
	 
	
	@RequestMapping(value = { "/cidades/novo" })
	public String novo(Cidade cidade) {
		return "cidades/cadastro-cidade";
	}

	
}