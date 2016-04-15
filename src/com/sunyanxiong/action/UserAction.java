package com.sunyanxiong.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sunyanxiong.biz.UserBiz;
import com.sunyanxiong.biz.impl.UserBizImpl;
import com.sunyanxiong.entities.User;

// 用户Action
public class UserAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 1L;

	// ModelDriven需要先创建一个User对象
	private User user = new User(); 

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private List<User> list;

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
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
	
	// 添加用户或者更新用户
	public String saveOrUpdate(){
		UserBiz userBiz = new UserBizImpl();
		userBiz.saveOrUpdate(user);
		return this.list();    // 调用list()方法将数据显示出来
	}
	
	// 删除用户
	public String delete(){
		UserBiz userBiz = new UserBizImpl();
		userBiz.deleteUser(user.getId());
		return this.list();
	}
	
	/*// 修改用户
	public String update(){
		UserBiz userBiz = new UserBizImpl();
		userBiz.updateUser(user);
		
		return "update";
		
	}*/
	
	   // 修改用户信息的回显逻辑
		public String toupdate(){
			UserBiz userBiz = new UserBizImpl();
			user = userBiz.getUserById(user.getId());
			System.out.println(user.getAddress()+user.getName());
			return "toupdate-success";
		}

		
		// 重点：调用getUser()将数据回显到页面，如果只调用this.user,数据将不会回显
		@Override
		public User getModel() {
			return this.getUser();
		}

		
}
