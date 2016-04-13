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

}
