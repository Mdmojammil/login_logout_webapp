package com.login_logout_webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login_logout_webapp.model.DAOService;
import com.login_logout_webapp.model.DAOServiceimpl;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      public login(){
        super();
       
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			DAOService service=new DAOServiceimpl();
			service.connectDB();
			boolean status=service.verifycredentials(email, password);
			if(status) {
				HttpSession session=request.getSession(true);
				session.setAttribute("email", email);
				RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/new_registration.jsp");
				rd.forward(request, response);
				}else {
				request.setAttribute("error", "invalid username/password");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		
	}

}
