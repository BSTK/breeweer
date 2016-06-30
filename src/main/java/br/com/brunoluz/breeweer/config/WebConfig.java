package br.com.brunoluz.breeweer.config;

import static br.com.brunoluz.breeweer.utils.CharacterEncoding.UTF_8;
import static br.com.brunoluz.breeweer.utils.ConstantsPath.BASE_PACKAGE_CLASSES;
import static br.com.brunoluz.breeweer.utils.ConstantsPath.CLASSPATH_STATIC;
import static br.com.brunoluz.breeweer.utils.ConstantsPath.CLASSPATH_TEMPLATES;
import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import br.com.brunoluz.breeweer.web.converter.EstiloConverter;

@EnableWebMvc
@Configuration
@ComponentScan(value = BASE_PACKAGE_CLASSES)
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
	
	
	private ApplicationContext applicationContext;
	
	
	/**
	 * ApplicationContext applicationContext
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	
	@Bean
	public FormattingConversionService mvcConversionService() {
		
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		conversionService.addConverter(new EstiloConverter());
		
		return conversionService;
		
	}
	
	
	@Bean
	public ViewResolver viewResolver() {
		
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding(UTF_8);
			
		return viewResolver;
		
	}
	
	
	/**
	 * Configura um bean gerenciado pelo Spring para usar o 
	 * TemplateEngine do Thymeleaf
	 * @return
	 */
	@Bean
	public ITemplateEngine templateEngine() {
		
		SpringTemplateEngine engine = new SpringTemplateEngine();	
		engine.setEnableSpringELCompiler(Boolean.TRUE);
		engine.setTemplateResolver(templateResolver());
		engine.addDialect(new LayoutDialect());
		
		return engine;
		
	}
	
	
	
	/**
	 * Configura o template resolver para usar o Thymeleaf
	 * @return
	 */
	private ITemplateResolver templateResolver() {
		
		SpringResourceTemplateResolver template = new SpringResourceTemplateResolver();
		template.setApplicationContext(applicationContext);
		template.setTemplateMode(TemplateMode.HTML);
		template.setPrefix(CLASSPATH_TEMPLATES);
		template.setSuffix(".html");
		
		return template;
		
	}
	
	
	
	/**
	 * Configura a localização dos arquivos estaticos (imagens, js e css)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_STATIC);
	}
	
	
}
