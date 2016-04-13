package com.sunyanxiong.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sunyanxiong.biz.UserBiz;
import com.sunyanxiong.biz.impl.UserBizImpl;
import com.sunyanxiong.entities.User;

// 用户Action
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;

	// ModelDriven需要先创建一个User对象
	private User user = new User();   
	
	private List<User> list;

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	@Override
	public User getModel() {
		return this.user;
	}
	
	public String list(){
		UserBiz userBiz = new UserBizImpl();
		list = userBiz.getAllUser();
		return "list-success";
	}

}
