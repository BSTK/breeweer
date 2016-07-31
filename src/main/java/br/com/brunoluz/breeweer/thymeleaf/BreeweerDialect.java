package br.com.brunoluz.breeweer.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import br.com.brunoluz.breeweer.thymeleaf.processor.ClassForErrorAttributTagProcessor;
import br.com.brunoluz.breeweer.thymeleaf.processor.MessageElementTagProcessor;

public class BreeweerDialect extends AbstractProcessorDialect {

	
	private final static String BREEWEER = "Breeweer";
	private final static String PREFIX = "breeweer";
	private final static int _PRECEDENCE = StandardDialect.PROCESSOR_PRECEDENCE;
	
	
	/**
	 * BreeweerDialect
	 * @param name
	 * @param prefix
	 * @param processorPrecedence
	 */
	public BreeweerDialect() {
		super(BREEWEER, PREFIX, _PRECEDENCE);
	}

	
	/**
	 * getProcessors
	 */
	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		
		final Set<IProcessor> processadores = new HashSet<IProcessor>();
		processadores.add(new ClassForErrorAttributTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		
		return processadores;
	}
	

}
