package br.com.brunoluz.breeweer.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.brunoluz.breeweer.model.Cerveja;
import br.com.brunoluz.breeweer.repository.CervejasRepository;


@Controller
public class CervejaController {
	 
	
	@Autowired
	private CervejasRepository cervejasRepository;
	
	@RequestMapping(value = { "/cervejas/novo" })
	public String novo(Cerveja cerveja) {
		
		cervejasRepository.findAll();
		return "cervejas/cadastro-cerveja";
		
	}
	
	
	@RequestMapping(value = { "/cervejas/novo" }, method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novo(cerveja);
		}
		
		attributes.addFlashAttribute("menssagem", "Cadastro com sucesso !");
		return "redirect:/cervejas/novo";
		
	}

	
}