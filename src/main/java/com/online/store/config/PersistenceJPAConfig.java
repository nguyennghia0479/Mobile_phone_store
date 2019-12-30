package com.online.store.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:database/database.properties" })
@ComponentScan({ "com.online.store" })
@EnableJpaRepositories(basePackages = "com.online.store.repository")
public class PersistenceJPAConfig {
	
	private final String PROPERTY_DRIVER = "jdbc.driverClassName";
	private final String PROPERTY_URL = "jdbc.url";
	private final String PROPERTY_USERNAME = "jdbc.username";
	private final String PROPERTY_PASSWORD = "jdbc.password";
	private final String PROPERTY_DIALECT = "hibernate.dialect";
	private final String PROPERTY_SHOW_SQL = "hibernate.show_sql";
	private final String PROPERTY_FORMAT_SQL = "hibernate.format_sql";
	private final String PROPERTY_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private final String PROPERTY_ENABLE_LAZY_LOAD = "hibernate.enable_lazy_load_no_trans";
	
	@Autowired
	private Environment environment;

	public PersistenceJPAConfig() {
		super();
	}

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan(new String[] { "com.online.store.entity" });
		final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.setJpaProperties(jpaProperties());
		return entityManagerFactoryBean;
	}

	final Properties jpaProperties() {
		Properties properties = new Properties();
		properties.setProperty(PROPERTY_DIALECT, this.environment.getProperty(PROPERTY_DIALECT));
		properties.setProperty(PROPERTY_SHOW_SQL, this.environment.getProperty(PROPERTY_SHOW_SQL));
		properties.setProperty(PROPERTY_FORMAT_SQL, this.environment.getProperty(PROPERTY_FORMAT_SQL));
		properties.setProperty(PROPERTY_HBM2DDL_AUTO, this.environment.getProperty(PROPERTY_HBM2DDL_AUTO));
		properties.setProperty(PROPERTY_ENABLE_LAZY_LOAD, this.environment.getProperty(PROPERTY_ENABLE_LAZY_LOAD));
		return properties;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.environment.getProperty(PROPERTY_DRIVER));
		dataSource.setUrl(this.environment.getProperty(PROPERTY_URL));
		dataSource.setUsername(this.environment.getProperty(PROPERTY_USERNAME));
		dataSource.setPassword(this.environment.getProperty(PROPERTY_PASSWORD));
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
