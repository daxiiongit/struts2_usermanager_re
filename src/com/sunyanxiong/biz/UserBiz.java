package com.sunyanxiong.biz;

import java.util.List;

import com.sunyanxiong.entities.User;

public interface UserBiz {

	public List<User> getAllUser();
	public int saveOrUpdate(User u);
	public int deleteUser(int id);
	/*public int updateUser(User u);*/
	public User getUserById(int id);
	
}
