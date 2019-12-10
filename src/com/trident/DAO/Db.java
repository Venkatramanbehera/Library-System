package com.trident.DAO;
import java.sql.*;
public class Db {
	public static Connection getCon() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root","chiku1234");
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
		
	}
}
