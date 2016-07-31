package br.com.brunoluz.breeweer.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.com.brunoluz.breeweer.model.Estilo;

public class EstiloConverter implements Converter<String, Estilo> {

	@Override
	public Estilo convert(String source) {
		
		if (Boolean.FALSE.equals(StringUtils.isEmpty(source))) {
			
			Estilo estilo = new Estilo();
			estilo.setId(Long.valueOf(source));
			return estilo;
			
		}
		
		return null;
		
	}

}
