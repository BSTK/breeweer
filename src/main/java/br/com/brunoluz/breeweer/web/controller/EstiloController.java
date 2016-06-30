package br.com.brunoluz.breeweer.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.brunoluz.breeweer.exception.NomeEstiloJaCadastradoException;
import br.com.brunoluz.breeweer.model.Estilo;
import br.com.brunoluz.breeweer.service.CadastroEstiloService;


@Controller
@RequestMapping(value = "/estilos")
public class EstiloController {
	 
	
	@Autowired
	private CadastroEstiloService service;
	
	
	@RequestMapping(value = { "/novo" }, method = RequestMethod.GET)
	public ModelAndView novo(Estilo estilo) {
		
		ModelAndView view = new ModelAndView("estilos/cadastro-estilo");
		view.addObject(estilo);
		
		return view;
	}
	
	
	@RequestMapping(value = { "/novo" }, method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novo(estilo);
		}
		
		try {
			
			service.salvar(estilo);
			attributes.addFlashAttribute("mensagem", "Estilo salva com sucesso!");
			
		} catch (NomeEstiloJaCadastradoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(estilo);
			
		}
		
		return new ModelAndView("redirect:/estilos/novo");
		
	}
	
	
	@RequestMapping( 
		method = RequestMethod.POST,
		consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public @ResponseBody ResponseEntity<?> cadastrarAjax(@RequestBody @Valid Estilo estilo, BindingResult result) {
		
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
		}
		
		estilo = service.salvar(estilo);
		
		return ResponseEntity.ok(estilo);
		
	}

	
}