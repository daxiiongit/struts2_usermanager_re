package com.sunyanxiong.dao;

import java.util.List;

import com.sunyanxiong.entities.User;

public interface UserDao {

	// 获取所有用户
	public List<User> getAllUser();
	// 添加用户
	public int addUser(User u);
	// 删除用户
	public int deleteUser(int id);
	
}
