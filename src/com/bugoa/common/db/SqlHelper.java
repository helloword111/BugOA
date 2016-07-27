package com.bugoa.common.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 这里是jdbc连接数据的四步操作
 * 这是一个对数据库进行操作的一个类
 * @author 陈李强
 * @since 2016-7-24
 */
public class SqlHelper {
	
	
		//定义需要的变量
		private static Connection ct = null;
		//在大多数情况下，我们使用的是PrepardStatement 来替代 Statement
		//这样可以防止sql 注入
		private static PreparedStatement ps=null;
		private static ResultSet rs = null;
		private static CallableStatement cs = null;
		
		//连接数据库参数
		private static String url = "";
		private static String username = "";
		private static String driver = "";
		private static String password = "";
		//读取配置文件
		private static Properties pp = null;
		private static InputStream fis = null;
	
		//第一步:加载驱动，只需要一次
			static{
				try{
					//从dbinfo.properties文件中读取配置信息
					pp = new Properties();
					//fis = new FileInputStream("dbinfo.properties"); //=>tomcat的主目录->bin文件
					//当我们使用java web的时候，读取文件要使用类加载器[因为类加载器去读取资源的时候，默认的主目录是src]
					fis = SqlHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
					pp.load(fis);
					url = pp.getProperty("url");
					username = pp.getProperty("username");
					driver = pp.getProperty("driver");
					password = pp.getProperty("password");
					Class.forName(driver);
				}catch (Exception e){
					e.printStackTrace();
				}finally{
					try{
						fis.close();
					}catch (IOException e){
						e.printStackTrace();
					}
					fis = null;
				}
			}
			
			
			//第二步：得到连接
			public static Connection getConnection(){
				try{
					ct = DriverManager.getConnection(url, username , password);
				}catch (Exception e){
					e.printStackTrace();
				}
				return ct;
			}
			
			
			//第三步：访问数据库
			//调用存储过程，有返回Result
			//sql call 过程  (?,?,?)
			public static CallableStatement callPro2
			(String sql,String [] inparameters,Integer [] outparmeters){
				
				try {
					ct = getConnection();
					cs = ct.prepareCall(sql);
					if(inparameters!=null){
						for(int i= 0;i<inparameters.length;i++){
							cs.setObject(i+1,inparameters[i]);
						}
					}
					
					//给out参数赋值
					if(outparmeters!=null){
						for(int i=0 ;i<outparmeters.length;i++){
							cs.registerOutParameter(inparameters.length+1+i, outparmeters[i]);
						}
					}
					
					cs.execute();
					
				}catch  (Exception e){
					e.printStackTrace();
					throw new RuntimeException(e.getMessage());
				}
				finally{
					//不需要关闭
				}
				return cs;
			}
			
			//调用存储过程
			//sql  象 {call  过程(?,?,?)}
			public static void callProl(String sql,String []parameters){
				try{
					ct = getConnection();
					cs = ct.prepareCall(sql);
					
					//？赋值
					if(parameters!= null){
						for(int i=0;i<parameters.length;i++){
							cs.setObject(i+1,parameters[i]);
						}
					}
					cs.execute();
				}catch(Exception e){
					e.printStackTrace();
					throw new RuntimeException(e.getMessage());
				}finally{
					close(rs , cs , ct);
				}
			}
			
			
			
			//第四部：执行查询，，统一的select
			//ResultSet->ArrayList
			public static ResultSet executeQuery(String sql,String []parameters){	
			
				try{
					ct = getConnection();
					ps = ct.prepareStatement(sql);
					if(parameters!=null && !parameters.equals("")){
						for(int i= 0;i<parameters.length;i++){
							ps.setString(i+1 , parameters[i]);
						}
					}
					rs=ps.executeQuery();
					
				}catch (Exception e){
					e.printStackTrace();
					throw new RuntimeException(e.getMessage());
				}finally{
					//close(rs , ps , ct);
				}
				
				return rs;
				
			}
			
			//如果有多个 udate/ delete /insert[需要考虑事务]
			public static void executeUpdate2(String sql[],String [][]parameters){  //+???
				try{
					//核心
					//1.获得连接
					ct = getConnection();
					
					//因为这时，用户传入的可能是多个sql语句.
					ct.setAutoCommit(false);
					//....
					for(int i=0;i<sql.length;i++){
						if(parameters[i] != null){
							ps = ct.prepareStatement(sql[i]);
							for(int j=0;j<parameters[i].length;j++){
								ps.setString(j+1, parameters[i][j]);
							}
							ps.executeUpdate();
						}
					}
					ct.commit();
					
					
					
				}catch(Exception e){
					e.printStackTrace();
					
					//回滚
					try{
						ct.rollback();
					}catch (SQLException e1){
						e1.printStackTrace();
					}
					
					throw new RuntimeException(e.getMessage());
					
				}finally{
					close(rs ,ps ,ct);
				}
			}
			//先写一个  update /delete  /insert
			//sql 格式：update 表名 set  字段名=?  where 字段 =？
			//parameters 应该是  {"abc",23};
			public static void executeUpdate(String sql,String [] parameters){ 
				//1.创建一个ps
				try{
					ct = getConnection();
					ps = ct.prepareStatement(sql);
					//给？赋值
					if(parameters != null){
						for(int i=0;i<parameters.length;i++){
							ps.setString(i+1, parameters[i]);
						}
					}
					
					//执行
					ps.executeUpdate();
				}catch (Exception e){
					e.printStackTrace();//开发阶段
					//抛出异常，抛出运行异常，可以给调用该函数的函数一个选择，
					//可以处理，也可以放弃处理
					throw new RuntimeException(e.getMessage());
				}finally{
					//关闭资源
					close(rs ,ps, ct);
				}
			}
			
			//关闭资源的函数
			public static void close(ResultSet rs,Statement ps,Connection ct){
				if(rs!=null){
					try{
						rs.close();
					}catch (Exception e){
						
					}
				}
				
				//关闭资源[先开后闭]
				if(ps!=null){
					try{
						ps.close();
					}catch (SQLException e){
						e.printStackTrace();
					}
					ps = null;//使用垃圾回收
				}
				if(ct!=null){
					try{
						ct.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
					ct = null;
				}
			}
			
			public static Connection getCt(){
				return ct;
			}
			
			public static PreparedStatement getPs(){
				return ps;
			}
			
			public static ResultSet getRs() {
				return rs;
			}
			
			public static CallableStatement getCs(){
				return cs;
			}

}
