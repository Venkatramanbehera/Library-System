package com.trident.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Admin Section</title>");
		out.println("<link rel='stylesheet' href='css/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		if(email.equals("admin@tat.ac.in")&&password.equals("admin65")) {
			HttpSession session=req.getSession();
			session.setAttribute("admin","true");
			req.getRequestDispatcher("adminpage.html").include(req, resp);
		}
		else {
			out.println("<div class='container'>");
			out.println("<h3>Username & password are incorrect</h3>");
			req.getRequestDispatcher("adminloginform.html").include(req, resp);
			out.println("</div>");
		}
		out.close();
	}
}
