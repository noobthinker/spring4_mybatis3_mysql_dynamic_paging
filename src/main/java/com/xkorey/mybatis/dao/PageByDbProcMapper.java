package com.xkorey.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.xkorey.mybatis.models.FunLog;
import com.xkorey.mybatis.models.User;


@Mapper
public interface PageByDbProcMapper {

	List<User> getUsersByPage(Map pageMap);
	
	List<User> getGroupUsersByFunLog(Map pageMap);
	
	List<FunLog> getUserLogs(Map pageMap);
	
	
}
