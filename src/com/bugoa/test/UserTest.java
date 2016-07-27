package com.bugoa.test;

import org.junit.Test;
import com.bugoa.pojo.User;
import com.bugoa.service.dao.IUserLogin;
import com.bugoa.service.impl.UserLoginImple;

/**
 * 
 * @<p> Title:UserTest </p>
 * @<p> Description: </p>
 * @author 陈李强
 * @date  下午3:24:17
 */
public class UserTest {
	private IUserLogin iUser = new UserLoginImple();

	@Test
	public void getUserByAccount_number() {
		User user = iUser.getUserByAccount_number("1405553116");
		System.out.println(user);
	}

	public static void main(String[] args) {
		IUserLogin iUser = new UserLoginImple();
		User user = iUser.getUserByAccount_number("1405553116");
		System.out.println(user);
	}
}
