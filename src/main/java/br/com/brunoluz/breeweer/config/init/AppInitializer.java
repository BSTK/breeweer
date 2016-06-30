package br.com.brunoluz.breeweer.config.init;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.brunoluz.breeweer.config.JPAConfig;
import br.com.brunoluz.breeweer.config.ServiceConfig;
import br.com.brunoluz.breeweer.config.WebConfig;
import br.com.brunoluz.breeweer.utils.CharacterEncoding;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	/**
	 * getRootConfigClasses
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { 
					JPAConfig.class, 
					ServiceConfig.class 
				};
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
	
	
	
	/**
	 * Define e força a utilização do encolding UTF-8
	 */
	@Override
	protected Filter[] getServletFilters() {
		
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding(CharacterEncoding.UTF_8);
		characterEncodingFilter.setForceEncoding(Boolean.TRUE);
		
		return new Filter[] { characterEncodingFilter };
		
	}
	

}
