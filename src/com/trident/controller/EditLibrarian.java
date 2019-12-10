package com.trident.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trident.DAO.LibrarianDao;
import com.trident.pojo.Librarian;

@SuppressWarnings("serial")
public class EditLibrarian extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String mobile=req.getParameter("mobile");
		Librarian lab=new Librarian(id,name,email,password,mobile);
		LibrarianDao.update(lab);
		resp.sendRedirect("ViewLibrarian");
	}
}
