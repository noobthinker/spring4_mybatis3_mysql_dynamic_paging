package com.xkorey.mybatis.service;

import java.util.List;

import com.xkorey.mybatis.models.FunLog;
import com.xkorey.mybatis.models.User;


public interface UserService {

	/**
	 * 分页获取用户
	 * @param begin 开始位置
	 * @param size  获取数量
	 * @return
	 */
	public List<User> getUserByList(Integer begin,Integer size);
	
	
	/**
	 * 分页获取用户log信息
	 * @param userId 用户id
	 * @param begin 开始位置
	 * @param size 获取数量
	 * @return
	 */
	public List<FunLog> getUserLogsList(Integer userId,Integer begin,Integer size);
	
}
