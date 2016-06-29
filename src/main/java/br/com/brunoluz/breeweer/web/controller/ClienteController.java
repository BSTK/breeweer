package br.com.brunoluz.breeweer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.brunoluz.breeweer.model.Cliente;


@Controller
public class ClienteController {
	 
	
	@RequestMapping(value = { "/clientes/novo" })
	public String novo(Cliente cliente) {
		return "clientes/cadastro-cliente";
	}

	
}