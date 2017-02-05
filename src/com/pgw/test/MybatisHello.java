package com.pgw.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
		selectIn();
		//selectWhere();
		//selectChoose();
		//selectIf();
		//selectCollection();
		//testSubSelect();
		//testAssociation();
		//testTransation();
		//selectAllByMap();
		//selectAll();
		//selectByMap();
		//selectByObject();
		//selectOne();
		//insertOne();
		//updateOne();
		//deleteOne();
		//updateSet();
		//updateTrim();
	}
	
	/**
	 * 查询结果集Where
	 */
	public static void selectIn(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			List<MidUser> midUsers = new ArrayList<MidUser>();
			MidUser miduser1 = new MidUser();
			miduser1.setUsercode("admin");
			MidUser miduser2 = new MidUser();
			miduser2.setUsercode("pgw");
			midUsers.add(miduser1);
			midUsers.add(miduser2);
			// 注意：这里是selectList
			List<MidUser> midusers = sqlSession.selectList("selectIn", midUsers);
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
	 * trim标签
	 */
	public static void updateTrim(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			MidUser midUser = new MidUser();
			midUser.setUsercode("pgw");
			//midUser.setUsername("pangwei");
			//midUser.setComcode("0080000");
			midUser.setPassword("999777");
			sqlSession.update("updateTrim", midUser);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * update中set标签
	 */
	public static void updateSet(){
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
			midUser.setComcode("0080000");
			midUser.setPassword("999777");
			sqlSession.update("updateSet", midUser);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 查询结果集Where
	 */
	public static void selectWhere(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			MidUser miduser = new MidUser();
			miduser.setUsercode("admin");
			miduser.setPassword("202cb962ac59075b964b07152d234b70");
			// 注意：这里是selectList
			List<MidUser> midusers = sqlSession.selectList("selectWhere", miduser);
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
	 * 查询结果集choose
	 */
	public static void selectChoose(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			MidUser miduser = new MidUser();
			//miduser.setUsercode("admin");
			//miduser.setPassword("202cb962ac59075b964b07152d234b70");
			// 注意：这里是selectList
			List<MidUser> midusers = sqlSession.selectList("selectChoose", miduser);
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
	 * 查询结果集if
	 */
	public static void selectIf(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			MidUser miduser = new MidUser();
			miduser.setUsercode("admin");
			miduser.setPassword("202cb962ac59075b964b07152d234b70");
			// 注意：这里是selectList
			List<MidUser> midusers = sqlSession.selectList("selectIf", miduser);
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
	 * 查询结果集
	 */
	public static void selectCollection(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 注意：这里是selectList
			List<MidUser> midusers = sqlSession.selectList("findAllCollection");
			for (int i = 0; i < midusers.size(); i++) {
				System.out.println(midusers.get(i).getUsercode()+":");
				if(midusers.get(i).getMidUserBusses()!= null){
					System.out.println(midusers.get(i).getMidUserBusses().size());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * resultMap 中 子查询练习
	 */
	public static void testSubSelect() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			List<MidUserBuss> midUserBuss = sqlSession.selectList("SubSelectBussAll");
			for (MidUserBuss mub : midUserBuss) {
				System.out.println(mub.getTaskcode());
				System.out.println("open lazy load ... ");
				// 懒加载机制开启后生效
				System.err.println(mub.getMiduser().getUsername()+":"+ mub.getMiduser().getPassword());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * resultMap 中 association属性练习
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
	 * 练习事务管理
	 */
	public static void testTransation(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 关闭自动提交，默认情况不传送false也是关闭的
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
			// 提交事务
			sqlSession.commit();
		} catch (IOException e) {
			// 事务回顾
			sqlSession.rollback();
		} finally {
			// 关闭session连接
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
	 * 通过parameterType="MidUser"查询
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
	 * 通过parameterType="HashMap"查询
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
	 * 查询结果集
	 */
	public static void selectAll(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 注意：这里是selectList
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
	 * 查询结果通过定义resultMap
	 */
	public static void selectAllByMap(){
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			// 注意：这里是selectList
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
