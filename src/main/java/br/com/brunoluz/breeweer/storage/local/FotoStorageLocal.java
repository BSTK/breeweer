package br.com.brunoluz.breeweer.storage.local;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import br.com.brunoluz.breeweer.storage.FotoStorage;

public class FotoStorageLocal implements FotoStorage {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FotoStorageLocal.class);

	private Path local;
	private Path localTemp;

	public FotoStorageLocal() {
		this(FileSystems.getDefault().getPath(System.getenv("HOMEPATH"),
				".breeweer-fotos"));
	}

	public FotoStorageLocal(Path local) {
		this.local = local;
		criarDiretorios();
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
	public byte[] reguperaFotoTemporaria(String nome) {
		try {

			return Files.readAllBytes(localTemp.resolve(nome));
		} catch (IOException e) {
			throw new RuntimeException(
					"Error ao ler a foto temporaria !\nError " + e.getMessage());
		}
	}

	private String renomeiaArquivoUpload(MultipartFile arquivo) {

		StringBuilder nomeArquivoUpload = new StringBuilder();
		nomeArquivoUpload.append(UUID.randomUUID().toString());
		nomeArquivoUpload.append("-");
		nomeArquivoUpload.append(arquivo.getOriginalFilename());

		LOGGER.info("Novo arquivo upload armazenado : "
				+ nomeArquivoUpload.toString());

		return nomeArquivoUpload.toString();
	}

	private void criarDiretorios() {

		try {

			Files.createDirectories(local);
			localTemp = FileSystems.getDefault().getPath(local.toString(),
					"temp");
			Files.createDirectories(localTemp);

			LOGGER.info("Pastas criadas para salvar fotos");
			LOGGER.info("Pasta local : " + local.toAbsolutePath());
			LOGGER.info("Pasta temporaria : " + localTemp.toAbsolutePath());

		} catch (Exception e) {
			throw new RuntimeException(
					"Error ao criar pastar para fotos !\nError "
							+ e.getMessage());
		}

	}

}
