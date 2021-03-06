package br.com.brunoluz.breeweer.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import br.com.brunoluz.breeweer.repository.CervejasRepository;
import br.com.brunoluz.breeweer.repository.EstiloRepository;
import br.com.brunoluz.breeweer.repository.filtro.CervejasFiltro;
import br.com.brunoluz.breeweer.service.CadastroCervejaService;
import br.com.brunoluz.breeweer.web.paginacao.PageWrapper;


@Controller
@RequestMapping("/cervejas")
public class CervejaController {
	 

	@Autowired
	private EstiloRepository estilos;
	
	@Autowired
	private CadastroCervejaService service;
	
	@Autowired
	private CervejasRepository cervejas;
	
	
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
	public ModelAndView pesquisa(CervejasFiltro cervejasFiltro, BindingResult result, 
			@PageableDefault(size = 2) Pageable pageable, HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView("cervejas/pesquisa-cerveja");
		view.addObject("sabores", Sabor.values());
		view.addObject("origens", Origem.values());
		view.addObject("estilos", estilos.findAll());
		view.addObject("pagina", new PageWrapper<Cerveja>(cervejas.filtrar(cervejasFiltro, pageable), request));
		
		return view;
	}

	
}