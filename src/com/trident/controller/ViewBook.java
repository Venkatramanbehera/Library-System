package com.trident.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trident.DAO.BookDao;
import com.trident.pojo.Book;

@SuppressWarnings("serial")
public class ViewBook extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Book</title>");
		out.println("<link rel='stylesheet' href='css/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		req.getRequestDispatcher("navbarlibrarian.html").include(req, resp);
		
		out.println("<div class='container'>");
		List<Book> list=BookDao.view();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Callno</th><th>Name</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th><th>Delete</th></tr>");
		for(Book bk:list){
			out.println("<tr><td>"+bk.getCallno()+"</td><td>"+bk.getName()+"</td><td>"+bk.getAuthor()+"</td><td>"+bk.getPublisher()+"</td><td>"+bk.getQuantity()+"</td><td>"+bk.getIssued()+"</td><td><a href='DeleteBook?callno="+bk.getCallno()+"'>Delete</a></td></tr>");
			//System.out.println(bk.getCallno());
		}
		out.println("</table>");
		
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
