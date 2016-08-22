package br.com.brunoluz.breeweer.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.brunoluz.breeweer.storage.FotosRunnable;
import br.com.brunoluz.breeweer.web.dto.FotoDTO;

@RestController
@RequestMapping("/fotos")
public class FotosController {

	
	@PostMapping
	public DeferredResult<FotoDTO> upload(@RequestParam("files[]") MultipartFile[] arquivos) {
		
		DeferredResult<FotoDTO> deferredResult = new DeferredResult<FotoDTO>();

		new Thread(new FotosRunnable(arquivos, deferredResult)).start();
		
		return deferredResult;
	}
	
}