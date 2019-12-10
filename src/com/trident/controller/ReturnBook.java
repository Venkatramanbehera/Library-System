package com.trident.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trident.DAO.BookDao;

@SuppressWarnings("serial")
public class ReturnBook extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Return Book</title>");
		out.println("<link rel='stylesheet' href='css/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		req.getRequestDispatcher("navbarlibrarian.html").include(req, resp);
		out.println("<div class='container'>");
		String callNo=req.getParameter("callno");
		String studentId=req.getParameter("studentid");
		int i=BookDao.returnBook(callNo, studentId);
		if(i>0) {
			out.println("<h3>Book returned sucessfully.</h3>");
		}
		else {
			out.println("<h3>Sorry,unable to return book</h3><p>We have some issue.</p>");
		}
		out.println("</div>");
		
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
