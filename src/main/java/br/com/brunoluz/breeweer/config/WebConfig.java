package br.com.brunoluz.breeweer.config;

import static br.com.brunoluz.breeweer.utils.ConstantsPath.BASE_PACKAGE_CLASSES;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(value = BASE_PACKAGE_CLASSES)
public class WebConfig extends WebMvcConfigurerAdapter {
	
	
}
