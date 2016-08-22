package br.com.brunoluz.breeweer.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {

	
	public String salvarTemporario(MultipartFile[] arquivos);
}
