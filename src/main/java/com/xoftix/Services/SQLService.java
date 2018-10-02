package com.xoftix.Services;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * Clase para mantener conexi�n persistencia SQL
 * 
 * */

public class SQLService {
	private static SqlSession sqlSession = null;
	private static SqlSessionFactory sesionFactory;
	
	public static void createSession() {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sesionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sesionFactory.openSession();
		}catch(IOException exp) {
			System.out.println("\n\tSQL Session Error");
		}
	}
	
	public static SqlSession getSQLService() throws IOException{
		
		if(sqlSession == null){
			createSession();
		}
		return sqlSession;
	}
}
