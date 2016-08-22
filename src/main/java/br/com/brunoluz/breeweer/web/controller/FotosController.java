package br.com.brunoluz.breeweer.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fotos")
public class FotosController {

	
	@PostMapping
	public String upload(@RequestParam("files[]") MultipartFile[] arquivos) {
		
		for (MultipartFile file : arquivos) 
			System.out.println("Nome : " + file.getOriginalFilename());
		
		return "OK Fotos !";
	}
	
}