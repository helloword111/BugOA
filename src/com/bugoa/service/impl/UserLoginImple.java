package com.bugoa.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bugoa.common.db.SqlHelper;
import com.bugoa.pojo.User;
import com.bugoa.service.dao.IUserLogin;

/**
 * 
 * @<p> Title:UserLoginImple </p>
 * @<p> Description: 这个接口实现类可以通过用户提交的账号的到数据库里面查询用户的资料，判断该用户是否存在
 *  				然后有一个方法是通过账号和密码来验证该用户是否合法</p>
 * @author 陈李强
 * @date 上午11:09:09
 */
public class UserLoginImple implements IUserLogin {

	@Override
	public User getUserByAccount_number(String account_number) {
		User user = new User();
		String sql = "select * from users where account_number=?";
		String parameters[] = { account_number };
		ResultSet rs = SqlHelper.executeQuery(sql, parameters);
		try {
			if (rs.next()) {
				// 二次封装
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setAccount_number(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setRoles(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block NULL
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		return user;
	}

	@Override
	public boolean checkUser(User user) {
		boolean b = false;

		// 使用SqlHelper来完成查询任务
		String sql = "select * from users where account_number=? and password=?";
		String parameters[] = { user.getAccount_number() + "",
				user.getPassword() };
		ResultSet rs = SqlHelper.executeQuery(sql, parameters);
		// 根据rs来判断该用户是否存在
		try {
			if (rs.next()) {
				b = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		return b;
	}

}
