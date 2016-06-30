package br.com.brunoluz.breeweer.utils;

public abstract class ConstantsPath {

	
	/**
	 * Pcote base da aplicação
	 */
	public static final String BASE_PACKAGE_CLASSES = "br.com.brunoluz.breeweer";
	
	
	/**
	 * Pcote base dos models
	 */
	public static final String BASE_PACKAGE_CLASSES_ENTITY = "br.com.brunoluz.breeweer.model";
	
	
	/**
	 * Pcote base dos repository
	 */
	public static final String BASE_PACKAGE_CLASSES_REPOSITORY = "br.com.brunoluz.breeweer.repository";
	
	
	/**
	 * Configura a pasta base para template
	 */
	public static final String CLASSPATH_TEMPLATES = "classpath:/templates/";
	
	
	/**
	 * Configura a pasta base para arquivos statics
	 */
	public static final String CLASSPATH_STATIC = "classpath:/static/";
	
	
	/**
	 * Configura o nome do datasource jndi
	 */
	public static final String DATASOURCE_JNDI_NAME = "jdbc/breeweerDB";
	
	
	/**
	 * Configura o no,e do dialect do hibernate/mysql
	 */
	public static final String DATABASE_PLATAFORM_NAME = "org.hibernate.dialect.MySQLDialect";
	
	
}
