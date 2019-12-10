package com.trident.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trident.DAO.BookDao;
import com.trident.pojo.IssueBookP;

@SuppressWarnings("serial")
public class ViewIssuedBook extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Issued Book</title>");
		out.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
		out.println("</head>");
		out.println("<body>");
		req.getRequestDispatcher("navbarlibrarian.html").include(req, resp);
		
		out.println("<div class='container'>");
		List<IssueBookP> list=BookDao.viewIssuedBooks();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Callno</th><th>Student Id</th><th>Student Name</th><th>Student Mobile</th><th>Issued Date</th><th>Return Status</th></tr>");
		for(IssueBookP ib:list) {
			out.println("<tr><td>"+ib.getCallNo()+"</td><td>"+ib.getStudentId()+"</td><td>"+ib.getStudentName()+"</td><td>"+ib.getStudentMobile()+"</td><td>"+ib.getIssuedDate()+"</td><td>"+ib.getReturnStatus()+"</td></tr>");
		}
		out.println("</table>");
		out.println("</div>");
		
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
		
	}
}
