package com.spring.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;

import com.spring.mapper.AdminMapper;
import com.spring.mapper.StudentMapper;

public class DAOFactory {
	private DAOFactory() {

	}
	
	private static SqlSession createSession() throws IOException {
		
		String resource = "mybatis-config.xml";
		
        InputStream inputStream = Resources.getResourceAsStream(resource);
        
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession(true);
		return session;
		
	}
	
	@Bean
	public static StudentMapper getStudentDao() throws IOException{
        return createSession().getMapper(StudentMapper.class);
	}
	
	@Bean
	public static AdminMapper getAdminDao() throws IOException
	{
		return createSession().getMapper(AdminMapper.class);
	}
}
