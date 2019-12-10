package com.trident.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trident.DAO.LibrarianDao;

@SuppressWarnings("serial")
public class DeleteLibrarian extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		LibrarianDao.delete(id);
		resp.sendRedirect("ViewLibrarian");
	}
}
