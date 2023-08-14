package com.prowings.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.prowings")
public class SpringBeansConfig {
	
	public DriverManagerDataSource dataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring-mvc-rest-assignment");
		ds.setUsername("root");
		ds.setPassword("Shubham@057");
		
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.prowings.entity");
		sessionFactory.setHibernateProperties(readHibernateProp());
		
		return sessionFactory;
		
	}
	
	
	public Properties  readHibernateProp() {
		
		Properties prop = new Properties();
		prop.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		prop.put("hibernate.show_sql","true");
		prop.put("hibernate.format_sql","true");
		prop.put("hibernate.hbm2ddl.auto","update");
		
		return prop;
	}
	
	
	
	
		

}
