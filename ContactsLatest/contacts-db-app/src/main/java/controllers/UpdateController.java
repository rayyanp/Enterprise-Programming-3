package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ContactsDAO;
import models.Contact;


@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		ContactsDAO dao = new ContactsDAO();
		
		Contact c = dao.selectContacts(id);
		request.setAttribute("contact", c);
		request.getRequestDispatcher("edit.jsp").include(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactsDAO dao = new ContactsDAO();
		Contact c = new Contact();
		
		c.setId(Integer.valueOf(request.getParameter("id")));
		c.setName(request.getParameter("name"));
		c.setEmail(request.getParameter("email"));
		
		
		
		try {
			dao.updateContact(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	    response.sendRedirect(request.getContextPath() + "/contacts");
	}

}
