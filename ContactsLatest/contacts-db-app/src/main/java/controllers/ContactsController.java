package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ContactsDAO;
import models.Contact;

/**
 * Dr Mohammed Kaleem
 * Lab Demo
 */
@WebServlet("/contacts")
public class ContactsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactsDAO dao = new ContactsDAO();
		ArrayList<Contact> allCons = dao.selectAllContacts();
		request.setAttribute("contacts", allCons);
		RequestDispatcher rd = request.getRequestDispatcher("contacts.jsp");
		rd.include(request, response);
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactsDAO dao = new ContactsDAO();
		Contact c = new Contact();
		
		c.setName(request.getParameter("name"));
		c.setEmail(request.getParameter("email"));
		
		
		
		try {
			dao.insertContact(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
		
	}

}
