package br.com.brunoluz.breeweer.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.brunoluz.breeweer.model.Cerveja;
import br.com.brunoluz.breeweer.model.Origem;
import br.com.brunoluz.breeweer.model.Sabor;
import br.com.brunoluz.breeweer.repository.EstiloRepository;
import br.com.brunoluz.breeweer.service.CadastroCervejaService;


@Controller
public class CervejaController {
	 

	@Autowired
	private EstiloRepository estilos;
	
	@Autowired
	private CadastroCervejaService service;
	
	
	@RequestMapping(value = { "/cervejas/novo" })
	public ModelAndView novo(Cerveja cerveja) {
		
		ModelAndView view = new ModelAndView("cervejas/cadastro-cerveja");
		view.addObject("sabores", Sabor.values());
		view.addObject("origens", Origem.values());
		view.addObject("estilos", estilos.findAll());
		
		return view;
		
	}
	
	
	@RequestMapping(value = { "/cervejas/novo" }, method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		
		ModelAndView view = new ModelAndView();
		
		if (result.hasErrors()) {
			return novo(cerveja);
		}
		
		service.salvar(cerveja);
		
		view.setViewName("redirect:/cervejas/novo");
		view.addObject("menssagem", "Cadastro com sucesso !");
		
		return view;
		
	}

	
}