package com.daham.configer;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration // This declares it as a Spring configuration class
@EnableWebMvc // This enables Spring's ability to receive and process web requests
@ComponentScan(basePackages = { "com.daham" }) // This scans the com.daham.controller package for Spring
												// components
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");
		return viewResolver;

	}

	@Bean
	JdbcTemplate jdbcTemplate() {

		JdbcTemplate jaJdbcTemplate = new JdbcTemplate(getDataSource());

		return jaJdbcTemplate;
	}

	@Bean
	DataSource getDataSource(){
		DriverManagerDataSource dataSource = new
				DriverManagerDataSource();

				 dataSource.setDriverClassName("org.postgresql.Driver");
				 dataSource.setUrl("jdbc:postgresql://localhost:5432/schooldb");
				 dataSource.setUsername("postgres");
				 dataSource.setPassword("postgres");
				 return dataSource;
    }
	@Bean
	public DataSourceTransactionManager transactionManager() {
	 DataSourceTransactionManager transactionManager = new
	DataSourceTransactionManager();
	 transactionManager.setDataSource(getDataSource());
	 return transactionManager;
	}

}
