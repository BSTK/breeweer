package br.com.brunoluz.breeweer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.brunoluz.breeweer.storage.FotoStorage;
import br.com.brunoluz.breeweer.storage.FotosRunnable;
import br.com.brunoluz.breeweer.web.dto.FotoDTO;

@RestController
@RequestMapping("/fotos")
public class FotosController {

	
	@Autowired
	private FotoStorage fotoStorage;
	
	@PostMapping
	public DeferredResult<FotoDTO> upload(@RequestParam("files[]") MultipartFile[] arquivos) {
		
		DeferredResult<FotoDTO> deferredResult = new DeferredResult<FotoDTO>();

		new Thread(new FotosRunnable(arquivos, deferredResult, fotoStorage)).start();
		
		return deferredResult;
	}
	
	
	@GetMapping("/temp/{nome:.*}")
	public byte[] reguperaFotoTemporaria(@PathVariable String nome) {
		return fotoStorage.reguperaFotoTemporaria(nome);
	}
	
	
	@GetMapping("/local/{nome:.*}")
	public byte[] reguperaFotoLocal(@PathVariable String nome) {
		return fotoStorage.reguperaFotoLocal(nome);
	}
	
	
}