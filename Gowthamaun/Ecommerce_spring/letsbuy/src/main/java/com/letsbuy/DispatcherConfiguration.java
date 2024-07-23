package com.letsbuy;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.DriverManagerDataSource;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.letsbuy")
@MapperScan(basePackages="com.letsbuy.mappers")
public class DispatcherConfiguration implements WebMvcConfigurer {
	
	@Bean
	public InternalResourceViewResolver internalViewResolver() {
		System.out.println("Inside the resolver");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
       // resolver.setViewNames("internal:*"); // Handle views with 'internal:' prefix
        //resolver.setOrder(1); // Lower priority
        return resolver;
	}
	
//	@Bean
//    public InternalResourceViewResolver externalViewResolver() {
//		System.out.println("Inside the resolver external");
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		 resolver.setPrefix("/");
//	        resolver.setSuffix(".jsp");
//	       // resolver.setViewNames("external:*"); // Handle views with 'external:' prefix
//	        resolver.setOrder(0); // Higher priority
//	        return resolver;
//    }

	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClass("oracle.jdbc.driver.OracleDriver");
		datasource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe"); 
		datasource.setUser("ecommercesystem"); 
		datasource.setPassword("oracle123"); 
		return datasource;
	}
	
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("Inside the assert handlers");
		  registry.addResourceHandler("/asserts/**")
          .addResourceLocations("/asserts/");
	}
}
