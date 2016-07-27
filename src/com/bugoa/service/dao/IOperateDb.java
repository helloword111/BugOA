package com.bugoa.service.dao;

import java.util.ArrayList;

import com.bugoa.pojo.User;

/**
 * 
 * @<p> Title:IOperateDb </p>
 * @<p> Description: </p>
 * @author 陈李强
 * @date  下午3:23:49
 */
public interface IOperateDb {
	
	/**
	 * 
	 * @param pageSize,,pageSize的值是在UserManagement里面定义为2，可以根据需要进行修改
	 * @return 表的总页数
	 */

	public int getPageCount(int pageSize);
	/**
	 * 
	 * @param pageNow  pageNow的初始值是1，用户可以直接输入pageNow的值，只要输入的值没有超过pageCount的值
	 * @param pageSize ,pageSize的值是在UserManagement里面定义为2，可以根据需要进行修改
	 * @return  返回集合al,对用户的信息进行遍历
	 */

	public ArrayList getUsersByPage(int pageNow, int pageSize);

	// 增加用户
	public boolean addUser(User user);

	// 修改用户
	public boolean updUser(User user);

	// 删除用户
	public boolean delUser(String id);

	// 查询
	public ArrayList getUsersByName(String name);

}
