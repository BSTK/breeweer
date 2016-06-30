package br.com.brunoluz.breeweer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static br.com.brunoluz.breeweer.utils.ConstantsPath.BASE_PACKAGE_CLASSES_SERVICE;

@Configuration
@ComponentScan(basePackages = BASE_PACKAGE_CLASSES_SERVICE)
public class ServiceConfig {
	
}
