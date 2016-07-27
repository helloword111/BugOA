package com.bugoa.service.impl;

import java.sql.*;

import java.util.ArrayList;

import com.bugoa.common.db.SqlHelper;

import com.bugoa.pojo.User;
import com.bugoa.service.dao.IOperateDb;


/**
 * 
 * @<p> Title:OperateDbImple </p>
 * @<p> Description: </p>
 * @author 陈李强
 * @date  下午3:24:36
 */
public class OperateDbImple implements IOperateDb {

	
	@Override
	// 获取pageCount
	public int getPageCount(int pageSize) {
		String sql = "select count(*) from users";
		int rowCount = 0;
		ResultSet rs = SqlHelper.executeQuery(sql, null);
		try {
			rs.next();
			rowCount = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}

		return (rowCount - 1) / pageSize + 1;
	}

	@Override
	// 按照分页来获取用户
	// 公司 把ResultSet-> User对象 -> ArrayList(集合)
	public ArrayList getUsersByPage(int pageNow, int pageSize) {
		ArrayList<User> al = new ArrayList<User>();

		// 查询sql
		String sql = "select * from users limit " + ((pageNow - 1) * pageSize)
				+ "," + pageSize;

		ResultSet rs = SqlHelper.executeQuery(sql, null);
		// 二次封装 把 把ResultSet-> User对象 -> ArrayList(集合)

		try {
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setAccount_number(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setRoles(rs.getString(5));
				;

				// 千万不要忘记 u->arraylist
				al.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}

		return al;
	}
	


	//添加用户
		public boolean  addUsers(User user ){
			boolean b=true;
			String sql="insert into users(name,password,grade,email)  values(?,?,?,?)";
			String parameters[]={user.getUsername(),user.getAccount_number(),user.getGrade()+"",user.getEmail()};
			try{
				SqlHelper.executeUpdate(sql, parameters);
			}catch (Exception e){
				e.printStackTrace();
				b=false;
			}
			return b;
		}
		
		
		
	// 查询
	public ArrayList getUsersByName(String name) {
		ArrayList<User> al = new ArrayList<User>();
		// 查询
		String sql = "select * from users where name=?";
		String[] parameters = { name };
		ResultSet rs = (ResultSet) SqlHelper.executeQuery(sql, parameters);
		// 二次封装
		try {
			while (rs.next()) {
				User u = new User();

				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setAccount_number(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setRoles(rs.getString(5));
				;
				al.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		return al;
	}

	// 修改角色
	public boolean updRole(User user) {
		boolean b = true;
		String sql = "update users set role=?,where account_number=?";
		String parameters[] = { user.getRoles(), user.getAccount_number() + "" };

		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			b = false;
		}
		return b;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delUser(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
