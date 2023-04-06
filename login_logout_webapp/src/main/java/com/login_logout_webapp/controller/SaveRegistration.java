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


@WebServlet("/SaveRegistration")
public class SaveRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       public SaveRegistration(){
        super();
      
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/new_registration.jsp");
			rd.forward(request, response);
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session=request.getSession(false);
			if(session.getAttribute("email")!=null) {
			
			String name=request.getParameter("name");
			String city=request.getParameter("city");
			String email=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			
			DAOService service=new DAOServiceimpl();
			service.connectDB();
			service.saveRegistration(name, city, email, mobile);
			
			request.setAttribute("msg", "recoard is save");
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/new_registration.jsp");
			rd.forward(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				
			}
			
		
	}

}
