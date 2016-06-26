package br.com.brunoluz.breeweer.config.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.brunoluz.breeweer.config.WebConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	/**
	 * getRootConfigClasses
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	
	/**
	 * Mapeia os controlles para que seja gerenciados pelos Spring
	 * getServletConfigClasses
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	
	/**
	 * Mapeia a url base para o Dispatcher Servlet do Spring
	 * getServletMappings
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
