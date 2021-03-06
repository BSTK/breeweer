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
	 * Pcote base dos services
	 */
	public static final String BASE_PACKAGE_CLASSES_SERVICE = "br.com.brunoluz.breeweer.service";
	
	
	/**
	 * Pcote Storage
	 */
	public static final String BASE_PACKAGE_CLASSES_STORAGE = "br.com.brunoluz.breeweer.storage";
	
	
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
