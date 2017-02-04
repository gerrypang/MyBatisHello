package com.pgw.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.pgw.pojo.MidUser;
import com.pgw.pojo.MidUserBuss;

public class MybatisHello {
	
	public static void main(String[] args) {
		testAssociation();
		//testTransation();
		//selectAllByMap();
		//selectAll();
		//selectByMap();
		//selectByObject();
		//selectOne();
		//insertOne();
		//updateOne();
		//deleteOne();
	}
	
	/**
	 * resultMap �� association������ϰ
	 */
	public static void testAssociation() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			List<MidUserBuss> midUserBuss = sqlSession.selectList("findAllByAssociation");
			for (MidUserBuss mub : midUserBuss) {
				System.out.println(mub.getMiduser().getUsername()+":"+ mub.getTaskcode());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	
	/**
	 * ��ϰ�������
	 */
	public static void testTransation(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// �ر��Զ��ύ��Ĭ�����������falseҲ�ǹرյ�
			sqlSession = sqlSessionFactory.openSession(false);
			MidUser midUser = new MidUser();
			midUser.setUsercode("pgw");
			midUser.setUsername("pang_guo_wei");
			midUser.setComcode("0000000");
			midUser.setPassword("123456");
			sqlSession.insert("insertMidUser", midUser);
			MidUserBuss midUserBuss = new MidUserBuss();
			midUserBuss.setMiduser(midUser);
			midUserBuss.setTaskcode("0000");
			midUserBuss.setFlag("0");
			sqlSession.insert("insertMidUserBuses", midUserBuss);
			// �ύ����
			sqlSession.commit();
		} catch (IOException e) {
			// ����ع�
			sqlSession.rollback();
		} finally {
			// �ر�session����
			sqlSession.close();
		}
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
	
	/**
	 * ͨ��parameterType="MidUser"��ѯ
	 */
	public static void selectByObject(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			MidUser midUser = new MidUser();
			midUser.setUsercode("pgw");
			midUser.setPassword("123456");
			MidUser miduser = sqlSession.selectOne("findByMap",midUser);
			System.out.println(miduser.getUsername());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * ͨ��parameterType="HashMap"��ѯ
	 */
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
	
	/**
	 * ��ѯ�����
	 */
	public static void selectAll(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// ע�⣺������selectList
			List<MidUser> midusers = sqlSession.selectList("findAll");
			for (int i = 0; i < midusers.size(); i++) {
				System.out.println(midusers.get(i).getUsername());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * ��ѯ���ͨ������resultMap
	 */
	public static void selectAllByMap(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// ע�⣺������selectList
			List<MidUser> midusers = sqlSession.selectList("findAllByMap");
			for (int i = 0; i < midusers.size(); i++) {
				System.out.println(midusers.get(i).getUsername());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
}
