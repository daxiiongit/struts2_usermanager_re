package com.sunyanxiong.biz.impl;

import java.util.List;

import com.sunyanxiong.biz.UserBiz;
import com.sunyanxiong.dao.UserDao;
import com.sunyanxiong.dao.impl.UserDaoImpl;
import com.sunyanxiong.entities.User;

public class UserBizImpl implements UserBiz{

	// 实例化 userDao
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public int saveOrUpdate(User u) {
		return userDao.saveOrUpdate(u);
	}

	@Override
	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	/*@Override
	public int updateUser(User u) {
		return userDao.updateUser(u);
	}*/

}
