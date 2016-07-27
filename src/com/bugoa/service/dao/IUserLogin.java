package com.bugoa.service.dao;

import com.bugoa.pojo.User;

/**
 * 
 * @<p> Title:IUserLogin </p>
 * @<p> Description:这个接口包含了两个方法，第一个是通过用户提交的账号来查询用户的资料，
 * 					第二个方法通过用户提交的账号和密码来验证该用户是否合法 </p>
 * @author 陈李强
 * @date  下午3:23:56
 */
public interface IUserLogin {

	/**
	 * 本方法可以实现通过账号查询用户资料
	 * 
	 * @param account_number ,,可以为空
	 *           
	 * @return user,,当传入的参数是空或者是错误的信息时，返回一个null;
	 */
	User getUserByAccount_number(String account_number);

	/**
	 * 本方法是进行用户的验证
	 * 
	 * @param user ，传入 的user已经被set进了用户提交的账号和密码的值，所以不会为空
	 * @return b,,b是true或false
	 */
	boolean checkUser(User user);
}
