package br.com.brunoluz.breeweer.config;

import static br.com.brunoluz.breeweer.utils.ConstantsPath.BASE_PACKAGE_CLASSES_ENTITY;
import static br.com.brunoluz.breeweer.utils.ConstantsPath.BASE_PACKAGE_CLASSES_REPOSITORY;
import static br.com.brunoluz.breeweer.utils.ConstantsPath.DATABASE_PLATAFORM_NAME;
import static br.com.brunoluz.breeweer.utils.ConstantsPath.DATASOURCE_JNDI_NAME;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = BASE_PACKAGE_CLASSES_REPOSITORY, enableDefaultTransactions = false)
@EnableTransactionManagement
public class JPAConfig {

	
	@Bean
	public DataSource dataSource() {
		
		JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
		jndiDataSourceLookup.setResourceRef(Boolean.TRUE);
		
		return jndiDataSourceLookup.getDataSource(DATASOURCE_JNDI_NAME);
		
	}
	
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		hibernateJpaVendorAdapter.setShowSql(Boolean.FALSE);
		hibernateJpaVendorAdapter.setGenerateDdl(Boolean.FALSE);
		hibernateJpaVendorAdapter.setDatabasePlatform(DATABASE_PLATAFORM_NAME);
		
		return hibernateJpaVendorAdapter;
		
	}
	
	
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		managerFactoryBean.setDataSource(dataSource());
		managerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		managerFactoryBean.setPackagesToScan(BASE_PACKAGE_CLASSES_ENTITY);
		managerFactoryBean.afterPropertiesSet();
		
		return managerFactoryBean.getObject();
		
	}
	
	
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
		
		return jpaTransactionManager;
		
	}
	
	
}
