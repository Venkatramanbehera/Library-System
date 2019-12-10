package com.trident.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trident.DAO.LibrarianDao;

@SuppressWarnings("serial")
public class LibrarianLogin extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Librarian Login</title>");
		out.println("<link rel=stylesheet' href='css/bootstrap.min.css'>");
		out.println("</head>");
		out.println("<body>");
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		if(LibrarianDao.authenticate(email, password)) {
			HttpSession s=req.getSession();
			s.setAttribute("email",email);
			//req.getRequestDispatcher("navbarlibrarian.html").include(req, resp);
			req.getRequestDispatcher("librarianfullpage.html").include(req, resp);
		}
		else {
			out.println("<div class='container'>");
			out.println("<h3>Username or Password error</h3>");
			req.getRequestDispatcher("librarianloginform.html").include(req, resp);
			out.println("</div>");
		}  
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
