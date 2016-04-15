package com.sunyanxiong.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.model.core.ID;
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
				u.setAddress(rs.getString("address"));
				
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
	public int saveOrUpdate(User u) {
		int result = 0;
		String sql_id = "select id from userinfo where id =" + u.getId();
		String sql_save = "insert into userinfo(name,sex,age,telephone,email,specialty,school,address) values(?,?,?,?,?,?,?,?)";
		String sql_update = "update userinfo set name=?,sex=?,age=?,telephone=?,email=?,specialty=?,school=?,address=? where id=" + u.getId();
		
		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql_id);
			rs = pstmt.executeQuery();
			if(rs.next()){   
				if((rs.getInt("id")) == u.getId()){  // 数据库中存在记录
					// 执行更新操作
					result = query_getId(u, sql_update);
				}
			}else{
				if(u.getId() == 0){
					// 执行新增操作
					result = query_getId(u, sql_save);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(con, pstmt, rs);
		}
		
		return result;
	}
	
	public int query_getId(User u,String sql){
		
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
			pstmt.setString(8, u.getAddress());
			
			System.out.println(u.getName());
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
	
	/*public int saveOrUpdate(User u,String sql){
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
			pstmt.setString(8, u.getAddress());
			
			System.out.println(u.getName());
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
	}*/

	// 删除用户
	@Override
	public int deleteUser(int id) {
		int result = 0;
		String sql = "delete from userinfo where id=?";
		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
			if(result != 0){
				System.out.println("删除成功！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(con, pstmt, rs);
		}
		
		return result;
	}

	/*public User queryOrUpdate(User us,String sql){
		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				us.setId(rs.getInt("id"));   // 将数据库中的数据放到对应的字段属性中
				us.setName(rs.getString("name"));
				us.setSex(rs.getString("sex"));
				us.setAge(rs.getInt("age"));
				us.setTelephone(rs.getString("telephone"));
				us.setEmail(rs.getString("email"));
				us.setSpecialty(rs.getString("specialty"));
				us.setSchool(rs.getString("school"));
				us.setAddredd(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstmt, rs);
		}
		return us;
	}*/
	
/*	// 修改数据
	@Override
	public int updateUser(User u) {
		int result = 0;
		System.out.println(u.getId());
		String sql = "update userinfo set name=?,sex=?,age=?,telephone=?,email=?,specialty=?,school=?,address=? where id=" + u.getId();
		result = saveOrUpdate(u, sql);
		return result;
	}*/

	@Override
	public User getUserById(int id) {
		User u = null;
		String sql = "select * from userinfo where id=" + id;
		try {
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			u = new User();
			if(rs.next()){
				u.setId(rs.getInt("id"));    // 将当前记录的id放到修改域中
				u.setName(rs.getString("name"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setTelephone(rs.getString("telephone"));
				u.setEmail(rs.getString("email"));
				u.setSpecialty(rs.getString("specialty"));
				u.setSchool(rs.getString("school"));
				u.setAddress(rs.getString("address"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(con, pstmt, rs);
		}
		return u;
	}
}
