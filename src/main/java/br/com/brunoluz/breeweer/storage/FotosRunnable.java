package br.com.brunoluz.breeweer.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.brunoluz.breeweer.utils.ArraysUtil;
import br.com.brunoluz.breeweer.web.dto.FotoDTO;

public class FotosRunnable implements Runnable {

	private final MultipartFile[] arquivos;
	private final DeferredResult<FotoDTO> deferred;
	
	
	public FotosRunnable(MultipartFile[] arquivos, DeferredResult<FotoDTO> deferred) {
		super();
		this.arquivos = arquivos;
		this.deferred = deferred;
	}


	@Override
	public void run() {
		
		if (Boolean.FALSE.equals(ArraysUtil.nullOuVazio(arquivos))) {
			
			FotoDTO foto = new FotoDTO();
			foto.setNome(arquivos[0].getOriginalFilename());
			foto.setContentType(arquivos[0].getContentType());
			
			deferred.setResult(foto);
		} 
		
	}

}
