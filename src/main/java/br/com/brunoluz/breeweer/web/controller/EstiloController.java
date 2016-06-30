package br.com.brunoluz.breeweer.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.brunoluz.breeweer.exception.NomeEstiloJaCadastrado;
import br.com.brunoluz.breeweer.model.Estilo;
import br.com.brunoluz.breeweer.service.CadastroEstiloService;


@Controller
public class EstiloController {
	 
	
	@Autowired
	private CadastroEstiloService service;
	
	
	@RequestMapping(value = { "/estilo/novo" })
	public ModelAndView novo(Estilo estilo) {
		
		ModelAndView view = new ModelAndView("estilo/cadastro-estilo");
		view.addObject(estilo);
		
		return view;
	}
	
	
	@RequestMapping(value = { "/estilo/novo" }, method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novo(estilo);
		}
		
		try {
			
			service.salvar(estilo);
			attributes.addFlashAttribute("mensagem", "Estilo salva com sucesso!");
			
		} catch (NomeEstiloJaCadastrado e) {
			
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(estilo);
			
		}
		
		return new ModelAndView("redirect:/estilo/novo");
		
	}

	
}