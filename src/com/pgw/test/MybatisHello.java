package com.pgw.test;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.pgw.pojo.MidUser;

public class MybatisHello {
	
	public static void main(String[] args) {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			MidUser miduser = sqlSession.selectOne("findById","admin");
			System.out.println(miduser.getUsername());
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
