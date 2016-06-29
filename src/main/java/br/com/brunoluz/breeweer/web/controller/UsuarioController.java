package br.com.brunoluz.breeweer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.brunoluz.breeweer.model.Usuario;


@Controller
public class UsuarioController {
	 
	
	@RequestMapping(value = { "/usuarios/novo" })
	public String novo(Usuario usuario) {
		return "usuarios/cadastro-usuario";
	}

	
}