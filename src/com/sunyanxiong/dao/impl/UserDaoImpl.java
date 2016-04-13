package com.sunyanxiong.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Result;
import com.sunyanxiong.dao.BaseDao;
import com.sunyanxiong.dao.UserDao;
import com.sunyanxiong.entities.User;

public class UserDaoImpl extends BaseDao implements UserDao{

	// 初始化数据库相关对象
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 获取所有用户信息
	@Override
	public List<User> getAllUser() {
		List<User> list = new ArrayList<User>();
		String sql = "select * from userinfo order by id";
		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			User u = null;
			while(rs.next()){
				u = new User();
				u.setId(rs.getInt("id"));   // 将数据库中的数据放到对应的字段属性中
				u.setName(rs.getString("name"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setTelephone(rs.getString("telephone"));
				u.setEmail(rs.getString("email"));
				u.setSpecialty(rs.getString("specialty"));
				u.setSchool(rs.getString("school"));
				u.setAddredd(rs.getString("address"));
				
				// 将属性值添加到list集合中
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstmt, rs);
		}
		return list;
	}

	@Override
	public int addUser(User u) {
		int result = 0;
		String sql = "insert into userinfo(name,sex,age,telephone,email,specialty,school,address) values(?,?,?,?,?,?,?,?)";
		result = saveOrUpdate(u, sql);
		return result;
	}
	
	public int saveOrUpdate(User u,String sql){
		int result = 0;
		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			
			// pstmt预编译处理
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getSex());
			pstmt.setInt(3, u.getAge());
			pstmt.setString(4, u.getTelephone());
			pstmt.setString(5, u.getEmail());
			pstmt.setString(6, u.getSpecialty());
			pstmt.setString(7, u.getSchool());
			pstmt.setString(8, u.getAddredd());
			
			// 添加数据到数据库
			result = pstmt.executeUpdate();
			if(result != 0){
				System.out.println("提交成功");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(con, pstmt, rs);
		}
		return result;
	}

}
