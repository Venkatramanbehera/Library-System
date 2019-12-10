package com.trident.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trident.DAO.LibrarianDao;
import com.trident.pojo.Librarian;

@SuppressWarnings("serial")
public class ViewLibrarian extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Librarian Section</title>");
		out.println("<link rel='stylesheet' href='css/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("navadmin.html").include(req, resp);
		out.println("<div class='container'>");
		List<Librarian> list=LibrarianDao.view();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th><th>Edit</th><th>Delete</th></tr>");
		for(Librarian lab:list){
			out.println("<tr><td>"+lab.getId()+"</td><td>"+lab.getName()+"</td><td>"+lab.getEmail()+"</td><td>"+lab.getPassword()+"</td><td>"+lab.getMobile()+"</td><td><a href='EditLibrarianForm?id="+lab.getId()+"'>Edit</a></td><td><a href='DeleteLibrarian?id="+lab.getId()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
