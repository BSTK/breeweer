package br.com.brunoluz.breeweer.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.brunoluz.breeweer.model.Cerveja;
import br.com.brunoluz.breeweer.model.Origem;
import br.com.brunoluz.breeweer.model.Sabor;
import br.com.brunoluz.breeweer.repository.CervejaRepository;
import br.com.brunoluz.breeweer.repository.EstiloRepository;
import br.com.brunoluz.breeweer.service.CadastroCervejaService;


@Controller
@RequestMapping("/cervejas")
public class CervejaController {
	 

	@Autowired
	private EstiloRepository estilos;
	
	@Autowired
	private CadastroCervejaService service;
	
	@Autowired
	private CervejaRepository cervejas;
	
	
	@GetMapping("/novo")
	public ModelAndView novo(Cerveja cerveja) {
		
		ModelAndView view = new ModelAndView("cervejas/cadastro-cerveja");
		view.addObject("sabores", Sabor.values());
		view.addObject("origens", Origem.values());
		view.addObject("estilos", estilos.findAll());
		
		return view;
		
	}
	
	
	@PostMapping("/novo")
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novo(cerveja);
		}
		
		service.salvar(cerveja);
		
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		
		return new ModelAndView("redirect:/cervejas/novo");
		
	}
	
	
	@GetMapping
	public ModelAndView pesquisa() {
		
		ModelAndView view = new ModelAndView("cervejas/pesquisa-cerveja");
		view.addObject("sabores", Sabor.values());
		view.addObject("origens", Origem.values());
		view.addObject("estilos", estilos.findAll());
		view.addObject("cervejas", cervejas.findAll());
		
		return view;
	}

	
}