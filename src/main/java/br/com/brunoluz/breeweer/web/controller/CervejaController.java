package br.com.brunoluz.breeweer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CervejaController {
	
	
	@RequestMapping("/cervejas/novo")
	public String novo() {
		return "cervejas/cadastro-cerveja";
	}
	
	
}