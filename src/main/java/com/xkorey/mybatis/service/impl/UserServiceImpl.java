package com.xkorey.mybatis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xkorey.mybatis.dao.PageByDbProcMapper;
import com.xkorey.mybatis.models.FunLog;
import com.xkorey.mybatis.models.User;
import com.xkorey.mybatis.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	PageByDbProcMapper pageDao;
	

	public List<User> getUserByList(Integer begin, Integer size) {
		Map page = new HashMap();
		page.put("pageBegin", begin);
		page.put("fetchSize", size);
		return pageDao.getUsersByPage(page);
	}
	
	public List<FunLog> getUserLogsList(Integer userId,Integer begin,Integer size){
		Map page = new HashMap();
		page.put("userId", userId);
		page.put("pageBegin", begin);
		page.put("fetchSize", size);
		return pageDao.getUserLogs(page);
	}

}
