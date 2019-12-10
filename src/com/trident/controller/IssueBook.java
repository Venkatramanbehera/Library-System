package com.trident.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trident.DAO.BookDao;
import com.trident.pojo.IssueBookP;

@SuppressWarnings("serial")
public class IssueBook extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Issue book</title>");
		out.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
		out.println("</head>");
		out.println("<body>");
		req.getRequestDispatcher("navbarlibrarian.html").include(req, resp);
		
		out.println("<div class='container'>");
		String callNo=req.getParameter("callno");
		String studentId=req.getParameter("studentid");
		String studentName=req.getParameter("Studentname");
		String studentMobile=req.getParameter("studentmobile");
		
		IssueBookP ib=new IssueBookP(callNo,studentId,studentName,studentMobile);
		int i=BookDao.issueBook(ib);
		if(i>0) {
			out.println("<h3>Book Issued Sucessfully</h3>");
		}else {
			out.println("<h3>Sorry, unable to issue book</h3><p>We may have sortage.Kindly visit later.</p>");
		}
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
