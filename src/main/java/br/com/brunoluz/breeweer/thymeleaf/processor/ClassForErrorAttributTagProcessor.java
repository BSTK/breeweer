package br.com.brunoluz.breeweer.thymeleaf.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring4.util.FieldUtils;
import org.thymeleaf.templatemode.TemplateMode;

public class ClassForErrorAttributTagProcessor extends AbstractAttributeTagProcessor {

	
	private static final String _ATRIBUTO = "classforerror";
	private static final int _PROCEDENCIA = 1000;
	
	
	/**
	 * ClassForErrorAttributTagProcessor
	 * @param dialectPrefix
	 */
	public ClassForErrorAttributTagProcessor(String dialectPrefix) {
		
		super(TemplateMode.HTML, dialectPrefix, 
			null, 
			Boolean.FALSE, 
			_ATRIBUTO, 
			Boolean.TRUE, 
			_PROCEDENCIA, 
			Boolean.TRUE);
	}

	
	/**
	 * Processa tag html
	 */
	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, 
			String attributeValue, IElementTagStructureHandler structureHandler) {
		
		boolean temErro = FieldUtils.hasErrors(context, attributeValue);
		
		if (temErro) {
			String classesExistentes = tag.getAttributeValue("class");
			structureHandler.setAttribute("class", classesExistentes.concat(" has-error"));
		}
		
	}

}
