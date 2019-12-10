package com.trident.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.trident.pojo.Book;
import com.trident.pojo.IssueBookP;

public class BookDao {
	public static int save(Book bk) {
		int status=0;
		try {
			Connection con=Db.getCon();
			PreparedStatement ps=con.prepareStatement("insert into library_management.e_book values(?,?,?,?,?,?)");
			ps.setString(1,bk.getCallno());
			ps.setString(2,bk.getName());
			ps.setString(3,bk.getAuthor());
			ps.setString(4,bk.getPublisher());
			ps.setInt(5,bk.getQuantity());
			ps.setInt(6,0);//0
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static List<Book> view(){
		List<Book> list=new ArrayList<Book>();
		try {
			Connection con=Db.getCon();
			PreparedStatement ps=con.prepareStatement("select * from library_management.e_book");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Book bk=new Book();
				bk.setCallno(rs.getString("callno"));
				bk.setName(rs.getString("name"));
				bk.setAuthor(rs.getString("author"));
				bk.setPublisher(rs.getString("publisher"));
				bk.setQuantity(rs.getInt("quantity"));
				bk.setIssued(rs.getInt("issued"));
				list.add(bk);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	public static boolean checkIssue(String callNo) {
		boolean status=false;
		try {
			Connection con=Db.getCon();
			PreparedStatement ps=con.prepareStatement("select * from library_management.e_book where callNo=? and quantity>issued");
			ps.setString(1,callNo);
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
	public static int getIssued(String callNo) {
		int issued=0;
		try {
			Connection con=Db.getCon();
			PreparedStatement ps=con.prepareStatement("select * from library_management.e_book where callno=?");
			ps.setString(1,callNo);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				issued=rs.getInt("issued");
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return issued;
	}
	public static int issueBook(IssueBookP ib) {
		String callNo=ib.getCallNo();
		boolean checkstatus=checkIssue(callNo);
		System.out.println("check status:"+checkstatus);
		if(checkstatus) {
			int status=0;
			try {
				Connection con=Db.getCon();
				PreparedStatement ps=con.prepareStatement("insert into library_management.e_issuebook values(?,?,?,?,?,?)");
				ps.setString(1,ib.getCallNo());
				ps.setString(2,ib.getStudentId());
				ps.setString(3,ib.getStudentName());
				ps.setString(4,ib.getStudentMobile());
				java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
				ps.setDate(5,currentDate);
				ps.setString(6,"no");
				System.out.println(ib.getStudentName());
				status=ps.executeUpdate();
				if(status>0) {
					PreparedStatement ps2=con.prepareStatement("update library_management.e_book set issued=? where callno=?");
					ps2.setInt(1,getIssued(callNo)+1);
					ps2.setString(2,callNo);
					status=ps2.executeUpdate();
				}
				con.close();
			}catch(Exception e) {
				System.out.println(e);
			}
			return status;
		}
		else {
			return 0;
		}				
	}
	
	public static int delete(String callNo) {
		int status=0;
		try {
			Connection con=Db.getCon();
			PreparedStatement ps=con.prepareStatement("delete from library_management.e_book where callNo=?");
			ps.setString(1,callNo);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static List<IssueBookP> viewIssuedBooks(){
		List<IssueBookP> list=new ArrayList<IssueBookP>();
		try {
			Connection con=Db.getCon();
			PreparedStatement ps=con.prepareStatement("select * from library_management.e_issuebook");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				IssueBookP ib=new IssueBookP();
				ib.setCallNo(rs.getString("callNo"));
				ib.setStudentId(rs.getString("studentid"));
				ib.setStudentName(rs.getString("studentname"));
				ib.setStudentMobile(rs.getString("studentmobile"));
				ib.setIssuedDate(rs.getDate("issuedate"));
				ib.setReturnStatus(rs.getString("returnstatus"));
				list.add(ib);
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	public static int returnBook(String callNo,String studentId) {
		int status=0;
		try {
			Connection con=Db.getCon();
			PreparedStatement ps=con.prepareStatement("update library_management.e_issuebook set returnstatus='yes' where callNo=? and studentId=?");
			ps.setString(1,callNo);
			ps.setString(2,studentId);
			status=ps.executeUpdate();
			if(status>0) {
				PreparedStatement ps2=con.prepareStatement("update library_management.e_book set issued=? where callNo=?");
				ps2.setInt(1,getIssued(callNo)-1);
				ps2.setString(2,callNo);
				status=ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
}
