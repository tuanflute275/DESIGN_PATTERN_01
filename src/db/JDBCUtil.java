package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/java";
			String username = "root";
			String password = "";
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			return null;
		}
	}

//	public static Connection getConnection() {
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=java";
//			String username = "sa";
//			String password = "1234$";
//			return DriverManager.getConnection(url, username, password);
//		} catch (Exception e) {
//			return null;
//		}
//	}
	
	/*
	 CREATE DATABASE java;
	 
	 CREATE TABLE Category
	(
		id int PRIMARY KEY AUTO_INCREMENT,
	    name varchar(200),
	    status boolean
	);
	
	
	CREATE TABLE Product
	(
		id int PRIMARY KEY AUTO_INCREMENT,
	    name varchar(200),
	    price double,
	    categoryId int,
	    status boolean
	);
	  
	  
	  
	 */
}
