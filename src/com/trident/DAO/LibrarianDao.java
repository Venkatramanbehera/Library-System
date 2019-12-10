package com.trident.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trident.pojo.Librarian;

public class LibrarianDao {
	public static int save(Librarian lab) {
		Integer status=0;
		try {
			Connection con=Db.getCon();
			PreparedStatement ps=con.prepareStatement("insert into library_management.e_librarian values(?,?,?,?,?)");
			ps.setString(1,lab.getId());
			ps.setString(2,lab.getName());
			ps.setString(3,lab.getPassword());
			ps.setString(4,lab.getEmail());
			ps.setString(5,lab.getMobile());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	public static List<Librarian> view(){
		List<Librarian> list= new ArrayList<Librarian>();
		try {
			Connection con=Db.getCon();
			PreparedStatement ps=con.prepareStatement("select * from library_management.e_librarian");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Librarian lab=new Librarian(null, null, null, null, null);
				lab.setId(rs.getString("id"));
				lab.setName(rs.getString("name"));
				lab.setEmail(rs.getString("email"));
				lab.setPassword(rs.getString("password"));
				lab.setMobile(rs.getString("mobile"));
				list.add(lab);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public static Librarian viewById(String id) {
		Librarian lab=new Librarian(null,null,null,null,null);
		try {
			Connection con=Db.getCon();
			PreparedStatement ps=con.prepareStatement("select * from library_management.e_librarian where id=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				lab.setId(rs.getString(1));
				lab.setName(rs.getString(2));
				lab.setPassword(rs.getString(3));
				lab.setEmail(rs.getString(4));
				lab.setMobile(rs.getString(5));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return lab;
	}
	
	public static int update(Librarian lab) {
		int status=0;
		try {
			Connection con=Db.getCon();
			PreparedStatement ps=con.prepareStatement("update library_management.e_librarian set name=?,email=?,password=?,mobile=? where id=?");
			ps.setString(1,lab.getName());
			ps.setString(2,lab.getEmail());
			ps.setString(3,lab.getPassword());
			ps.setString(4,lab.getMobile());
			ps.setString(5,lab.getId());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int delete(String id) {
		int status=0;
		try {
			Connection con=Db.getCon();
			PreparedStatement ps=con.prepareStatement("delete from library_management.e_librarian where id=?");
			ps.setString(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static boolean authenticate(String email,String password) {
		boolean status=false;
		try {
			
			Connection con=Db.getCon();
			PreparedStatement ps=con.prepareStatement("select * from library_management.e_librarian where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				status=true;
			}	
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}	
		return status;
	}
	
	
	
	
	
}
