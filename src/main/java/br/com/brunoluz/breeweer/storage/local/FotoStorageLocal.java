package br.com.brunoluz.breeweer.storage.local;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import br.com.brunoluz.breeweer.storage.FotoStorage;

public class FotoStorageLocal implements FotoStorage {

	private static final Logger LOGGER = LoggerFactory.getLogger(FotoStorageLocal.class);

	private Path local;
	private Path localTemp;

	public FotoStorageLocal() {
		this(FileSystems.getDefault().getPath(System.getenv("HOMEPATH"),".breeweer-fotos"));
	}

	public FotoStorageLocal(Path local) {
		this.local = local;
		criarDiretorios();
	}
	
	
	@Override
	public void salvar(String foto) {
		try {
			
			Files.move(localTemp.resolve(foto), local.resolve(foto));
			
			if (LOGGER.isInfoEnabled()) {
				LOGGER.info("Movendo Fotos");
				LOGGER.info("Movendo de : " + localTemp.resolve(foto).toString());
				LOGGER.info("Para : " + local.resolve(foto).toString());
			}
			
			Thumbnails.of(local.resolve(foto).toString())
					.size(40, 48)
					.toFiles(Rename.PREFIX_HYPHEN_THUMBNAIL);
			
		} catch (Exception e) {}
	}
	

	@Override
	public String salvarTemporario(MultipartFile[] arquivos) {

		String nomeArquivo = "";
		try {

			MultipartFile arquivo = arquivos[0];
			nomeArquivo = renomeiaArquivoUpload(arquivo);
			arquivo.transferTo(new File(localTemp
					.toAbsolutePath()
					.toString()
					.concat(FileSystems.getDefault().getSeparator()
							.concat(nomeArquivo))));

		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException("Error ao salvar fotos !\nError "
					+ e.getMessage());
		}

		return nomeArquivo;

	}
	
	
	@Override
	public byte[] reguperaFotoLocal(String nome) {
		try {
			
			return Files.readAllBytes(local.resolve(nome));
			
		} catch (IOException e) {
			throw new RuntimeException("Error ao ler a foto local !\nError " + e.getMessage());
		}
	}

	
	@Override
	public byte[] reguperaFotoTemporaria(String nome) {
		try {

			return Files.readAllBytes(localTemp.resolve(nome));
			
		} catch (IOException e) {
			throw new RuntimeException("Error ao ler a foto temporaria !\nError " + e.getMessage());
		}

	}

	
	private String renomeiaArquivoUpload(MultipartFile arquivo) {

		StringBuilder nomeArquivoUpload = new StringBuilder();
		nomeArquivoUpload.append(UUID.randomUUID().toString());
		nomeArquivoUpload.append("-");
		nomeArquivoUpload.append(arquivo.getOriginalFilename());

		LOGGER.info("Novo arquivo upload armazenado : " + nomeArquivoUpload.toString());

		return nomeArquivoUpload.toString();
	}

	
	private void criarDiretorios() {

		try {

			Files.createDirectories(local);
			localTemp = FileSystems.getDefault().getPath(local.toString(),"temp");
			Files.createDirectories(localTemp);

			LOGGER.info("Pastas criadas para salvar fotos");
			LOGGER.info("Pasta local : " + local.toAbsolutePath());
			LOGGER.info("Pasta temporaria : " + localTemp.toAbsolutePath());

		} catch (Exception e) {
			throw new RuntimeException("Error ao criar pastar para fotos !\nError " + e.getMessage());
		}

	}

}
