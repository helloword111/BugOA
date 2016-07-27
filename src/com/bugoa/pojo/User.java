package com.bugoa.pojo;
/**
 * 
 * @<p> Title:User </p>
 * @<p> Description: </p>
 * @author 陈李强
 * @date  下午3:24:49
 */

public class User {
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 账号
	 */
	private String account_number;
	/**
	 * 角色
	 */
	private String roles;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 手机长号
	 */
	private String tel_long;
	/**
	 * 手机短号
	 */
	private int tel_short;
	/**
	 * QQ
	 */
	private String QQ;
	/**
	 * 邮箱
	 */
	private String mailbox;
	/**
	 * 方向
	 */
	private String direction;

	/**
	 * 获取主键
	 * 
	 * @return id 主键
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置主键
	 * 
	 * @param id
	 *            主键
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取用户名
	 * 
	 * @return username 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置用户名
	 * 
	 * @param username
	 *            用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取账号
	 * 
	 * @return account_number 账号
	 */
	public String getAccount_number() {
		return account_number;
	}

	/**
	 * 设置账号
	 * 
	 * @param account_number
	 *            账号
	 */
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	/**
	 * 获取角色
	 * 
	 * @return roles 角色
	 */
	public String getRoles() {
		return roles;
	}

	/**
	 * 设置角色
	 * 
	 * @param roles
	 *            角色
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}

	/**
	 * 获取密码
	 * 
	 * @return password 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 * 
	 * @param password
	 *            密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取性别
	 * 
	 * @return sex 性别
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置性别
	 * 
	 * @param sex
	 *            性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 获取手机长号
	 * 
	 * @return tel_long 手机长号
	 */
	public String getTel_long() {
		return tel_long;
	}

	/**
	 * 设置手机长号
	 * 
	 * @param tel_long
	 *            手机长号
	 */
	public void setTel_long(String tel_long) {
		this.tel_long = tel_long;
	}

	/**
	 * 获取手机短号
	 * 
	 * @return tel_short 手机短号
	 */
	public int getTel_short() {
		return tel_short;
	}

	/**
	 * 设置手机短号
	 * 
	 * @param tel_short
	 *            手机短号
	 */
	public void setTel_short(int tel_short) {
		this.tel_short = tel_short;
	}

	/**
	 * 获取qQ
	 * 
	 * @return qQ qQ
	 */
	public String getQQ() {
		return QQ;
	}

	/**
	 * 设置qQ
	 * 
	 * @param qQ
	 *            qQ
	 */
	public void setQQ(String qQ) {
		QQ = qQ;
	}

	/**
	 * 获取邮箱
	 * 
	 * @return mailbox 邮箱
	 */
	public String getMailbox() {
		return mailbox;
	}

	/**
	 * 设置邮箱
	 * 
	 * @param mailbox
	 *            邮箱
	 */
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	/**
	 * 获取方向
	 * 
	 * @return direction 方向
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * 设置方向
	 * 
	 * @param direction
	 *            方向
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * 无参构造方法
	 */
	public User() {

	}

	public User(int id, String username, String account_number, String roles,
			String password, String sex, String tel_long, int tel_short,
			String QQ, String mailbox, String direction) {
		this.id = id;
		this.username = username;
		this.account_number = account_number;
		this.roles = roles;
		this.password = password;
		this.sex = sex;
		this.tel_long = tel_long;
		this.tel_short = tel_short;
		this.QQ = QQ;
		this.mailbox = mailbox;
		this.direction = direction;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"username\":\"" + username
				+ "\",\"account_number\":\"" + account_number
				+ "\",\"roles\":\"" + roles + "\",\"password\":\"" + password
				+ "\",\"sex\":\"" + sex + "\",\"tel_long\":\"" + tel_long
				+ "\",\"tel_short\":\"" + tel_short + "\",\"QQ\":\"" + QQ
				+ "\",\"mailbox\":\"" + mailbox + "\",\"direction\":\""
				+ direction + "\"}";
	}


}
