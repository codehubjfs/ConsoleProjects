package com.bus;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan("com.bus")
@MapperScan("com.bus.mapper") 

public class Dispatcherconfig implements WebMvcConfigurer {  
	    @Bean
	    public InternalResourceViewResolver getResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/WEB-INF/views/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }  
	    
	    @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    	 registry.addResourceHandler("/style/**")
	         .addResourceLocations("/style/");
	    	  registry.addResourceHandler("/Images/**")
	          .addResourceLocations("/Images/");
	    } 
	    
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource datasource = new DriverManagerDataSource();
	        datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	        datasource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); 
	        datasource.setUsername("ticketbooking");
	        datasource.setPassword("root"); 
	        return datasource;
	    }
	    
	    @Bean
	    public SqlSessionFactory sqlSessionFactory() throws Exception {
	        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        return sessionFactory.getObject();
	    }
	    
	    @Bean
	    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
	        return new SqlSessionTemplate(sqlSessionFactory);
	    }
}