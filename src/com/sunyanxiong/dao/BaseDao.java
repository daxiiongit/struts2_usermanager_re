package com.sunyanxiong.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 连接数据库
public class BaseDao {

	// 连接
	public Connection getConnection(){
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/user";
		String user = "root";
		String password = "sunyanxiong";
		try {
			// 配置连接数据库
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 关闭数据库相关对象
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		//关闭结果集
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 关闭编译执行sql对象
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 关闭数据库连接对象
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
