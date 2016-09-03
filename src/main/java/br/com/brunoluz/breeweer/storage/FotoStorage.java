package br.com.brunoluz.breeweer.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {

	
	public String salvarTemporario(MultipartFile[] arquivos);

	public byte[] reguperaFotoTemporaria(String nome);
	
	public byte[] reguperaFotoLocal(String nome);

	public void salvar(String foto);

	
}
