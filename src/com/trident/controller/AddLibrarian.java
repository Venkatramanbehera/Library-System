package com.trident.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trident.DAO.LibrarianDao;
import com.trident.pojo.Librarian;

@SuppressWarnings("serial")
public class AddLibrarian extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Librian</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("navadmin.html").include(req, resp);
		out.println("<div class='container'>");
		String id=req.getParameter("libid");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String mobileNumber=req.getParameter("mobile");	
		Librarian lab=new Librarian(id,name,password,email,mobileNumber);
		LibrarianDao.save(lab);
		out.println("<h4>Librarian save sucessfully</h4>");
		req.getRequestDispatcher("addlibrarianform.html").include(req, resp);
		
		out.println("</div>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
