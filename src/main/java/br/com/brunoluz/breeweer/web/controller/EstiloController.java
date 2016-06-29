package br.com.brunoluz.breeweer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.brunoluz.breeweer.model.Estilo;


@Controller
public class EstiloController {
	 
	
	@RequestMapping(value = { "/estilo/novo" })
	public String novo(Estilo estilo) {
		return "estilo/cadastro-estilo";
	}

	
}