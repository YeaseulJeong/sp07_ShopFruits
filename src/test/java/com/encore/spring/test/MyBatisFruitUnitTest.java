package com.encore.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.encore.spring.domain.Item;

public class MyBatisFruitUnitTest {
	@Test
	public void uTest() throws Exception{
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();  
		
		System.out.println("====1. 모든 과일 불러오기====");
		List<Item> list = session.selectList("FruitsMapper.getItemList");
		for(Item i : list ) System.out.println(i);
		
		System.out.println("====2. 특정 과일 불러오기====");
		Item item = session.selectOne("FruitsMapper.getItem", 3);
		System.out.println(item);
		
		
	}

}
