package com.trident.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trident.DAO.BookDao;
import com.trident.pojo.Book;

@SuppressWarnings("serial")
public class AddBook extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Book Form</title>");
		out.println("<link rel='stylesheet' href='css/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		req.getRequestDispatcher("navbarlibrarian.html").include(req, resp);
		
		out.println("<div class='container'>");
		String callno=req.getParameter("callno");
		String name=req.getParameter("name");
		String author=req.getParameter("author");
		String publisher=req.getParameter("publisher");
		String squantity=req.getParameter("quantity");
		Integer quantity=Integer.parseInt(squantity);
		Book bk=new Book(callno,name,author,publisher,quantity);
		int i=BookDao.save(bk);
		if(i>0) {
			out.println("<h3>Book Saved Sucessfully</h3>");
		}
		req.getRequestDispatcher("addbookform.html").include(req, resp);
		out.println("</div>");
		
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
