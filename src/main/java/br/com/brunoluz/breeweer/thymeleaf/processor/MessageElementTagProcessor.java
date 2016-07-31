package br.com.brunoluz.breeweer.thymeleaf.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class MessageElementTagProcessor extends AbstractElementTagProcessor {

	
	private static final String TAG_NAME = "message";
	private static final int _PROCEDENCIA = 1000;
	
	
	/**
	 * MessageElementTagProcessor
	 * @param dialectPrefix
	 */
	public MessageElementTagProcessor(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, TAG_NAME, Boolean.TRUE,
				null, Boolean.FALSE, _PROCEDENCIA);
	}

	
	
	/**
	 * doProcess
	 */
	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag, IElementTagStructureHandler structureHandler) {
		
		IModelFactory modelFactory = context.getModelFactory();
	
		IModel model = modelFactory.createModel();
		model.add(modelFactory.createStandaloneElementTag("th:block", "th:include", "fragments/menssagens/menssagens-error :: menssagens-error"));
		model.add(modelFactory.createStandaloneElementTag("th:block", "th:include", "fragments/menssagens/menssagens-sucesso :: menssagem-sucesso"));

		structureHandler.replaceWith(model, Boolean.TRUE);
		
	}

}
