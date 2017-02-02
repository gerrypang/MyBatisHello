package com.pgw.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pgw.pojo.MidUser;

public class MybatisHello {
	
	public static void main(String[] args) {
		selectByMap();
		//selectOne();
		//insertOne();
		//updateOne();
		//deleteOne();
	}
	
	public static void deleteOne(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.delete("deleteMidUser", "pgw");
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public static void updateOne(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			MidUser midUser = new MidUser();
			midUser.setUsercode("pgw");
			midUser.setUsername("pangwei");
			midUser.setComcode("0000000");
			midUser.setPassword("9");
			sqlSession.update("updateMidUser", midUser);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public static void insertOne(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			MidUser midUser = new MidUser();
			midUser.setUsercode("pgw");
			midUser.setUsername("pang_guo_wei");
			midUser.setComcode("0000000");
			midUser.setPassword("123456");
			sqlSession.insert("insertMidUser", midUser);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public static void selectByMap(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("usercode", "admin");
			map.put("password", "202cb962ac59075b964b07152d234b70");
			MidUser miduser = sqlSession.selectOne("findByMap",map);
			System.out.println(miduser.getUsername());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public static void selectOne(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			MidUser miduser = sqlSession.selectOne("findById","admin");
			System.out.println(miduser.getUsername());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
}
