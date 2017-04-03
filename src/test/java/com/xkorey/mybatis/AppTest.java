package com.xkorey.mybatis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xkorey.mybatis.models.FunLog;
import com.xkorey.mybatis.models.User;
import com.xkorey.mybatis.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-base.xml")
public class AppTest 
{
	
	@Autowired
	UserService userService;
	
	
	
	@Test
	public void testGetUserLogsByPage(){
//		List<FunLog> logs = userService.getUserLogsList(1,0,2);  
		List<FunLog> logs = userService.getUserLogsList(1,4,6);
		System.out.println(logs.size());
		for(FunLog log:logs){
			System.out.println(log.getInfo());
		}
	}
	
	@Test
	public void testGetUserByPage(){
//		List<User> users = userService.getUserByList(0,3);
		List<User> users = userService.getUserByList(4,6);
		System.out.println(users.size());
		for(User user:users){
			System.out.println(user.getUserName());
		}
	}
	
	
}
