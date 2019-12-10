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
public class EditLibrarianForm extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit librarian Form</title>");
		out.println("<link rel='stylesheet' href='css/bootstrap.min.css'>");
		out.println("<head>");
		out.println("<body>");
		
		req.getRequestDispatcher("navadmin.html").include(req, resp);
		out.println("<div class='container'>");
		String lid=req.getParameter("id");
		
		Librarian lab=LibrarianDao.viewById(lid);
		
		out.println("<form action='EditLibrarian' method='post' style='width:300px'>");
		out.println("<div class=''form-group>");
		out.println("<input type='hidden' name='id' value='"+lab.getId()+"'/>");
		out.println("<label for='name1'>Name</label>");
		out.println("<input type='text' class='form-control' value='"+lab.getName()+"' name='name' id='name1' placeholder='Name'/>");
		out.println("</div>");
		out.println("<div class=''form-group>");
		out.println("<label for='email1'>Email address</label>");
		out.println("<input type='email' class='form-control' value='"+lab.getEmail()+"' name='email' id='email1' placeholder='Email'/>");
		out.println("</div>");
		out.println("<div class=''form-group>");
		out.println("<label for='password1'>Password</label>");
		out.println("<input type='password' class='form-control' value='"+lab.getPassword()+"' name='password' id='password1' placeholder='Password'/>");
		out.println("</div>");
		out.println("<div class=''form-group>");
		out.println("<label for='mobile1'>Mobile Number</label>");
		out.println("<input type='text' class='form-control' value='"+lab.getMobile()+"' name='mobile' id='mobile1' placeholder='MobileNumber'/>");
		out.println("</div>");
		out.println("<button type='submit' class='btn btn-primary'>Update</button>");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</body>");
		req.getRequestDispatcher("footer.html").include(req, resp);
		out.close();
	}
}
