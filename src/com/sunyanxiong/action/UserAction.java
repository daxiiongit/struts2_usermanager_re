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
	
	// 配置添加页面性别
	private String[] sexs = new String[]{"男","女"};
	
	public String[] getSexs() {
		return sexs;
	}

	public void setSexs(String[] sexs) {
		this.sexs = sexs;
	}

	public String toAdd(){
		return "toAdd-success";
	}
	
	// 添加用户
	public String add(){
		UserBiz userBiz = new UserBizImpl();
		userBiz.addUser(user);
		return this.list();    // 调用list()方法将数据显示出来
	}
	
	// 删除用户
	public String delete(){
		UserBiz userBiz = new UserBizImpl();
		userBiz.deleteUser(user.getId());
		return this.list();
	}

}
