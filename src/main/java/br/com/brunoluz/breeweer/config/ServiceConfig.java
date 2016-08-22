package br.com.brunoluz.breeweer.config;

import static br.com.brunoluz.breeweer.utils.ConstantsPath.BASE_PACKAGE_CLASSES_SERVICE;
import static br.com.brunoluz.breeweer.utils.ConstantsPath.BASE_PACKAGE_CLASSES_STORAGE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.brunoluz.breeweer.storage.FotoStorage;
import br.com.brunoluz.breeweer.storage.local.FotoStorageLocal;

@Configuration
@ComponentScan(basePackages = { BASE_PACKAGE_CLASSES_SERVICE, BASE_PACKAGE_CLASSES_STORAGE })
public class ServiceConfig {

	@Bean
	public FotoStorage fotoStorage() {
		return new FotoStorageLocal();
	}
	
}