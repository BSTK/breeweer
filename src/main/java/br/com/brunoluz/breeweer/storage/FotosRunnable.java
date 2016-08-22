package br.com.brunoluz.breeweer.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.brunoluz.breeweer.utils.ArraysUtil;
import br.com.brunoluz.breeweer.web.dto.FotoDTO;

public class FotosRunnable implements Runnable {

	private final MultipartFile[] arquivos;
	private final DeferredResult<FotoDTO> deferred;
	private final FotoStorage fotoStorage;
	
	
	public FotosRunnable(MultipartFile[] arquivos, DeferredResult<FotoDTO> deferred, FotoStorage fotoStorage) {
		super();
		this.arquivos = arquivos;
		this.deferred = deferred;
		this.fotoStorage = fotoStorage;
	}


	@Override
	public void run() {
		
		if (Boolean.FALSE.equals(ArraysUtil.nullOuVazio(arquivos))) {
			
			String nomeFoto = fotoStorage.salvarTemporario(arquivos);
			
			FotoDTO foto = new FotoDTO();
			foto.setNome(nomeFoto);
			foto.setContentType(arquivos[0].getContentType());
			
			deferred.setResult(foto);
		} 
		
	}

}
