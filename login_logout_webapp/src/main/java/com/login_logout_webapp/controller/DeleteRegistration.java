package com.login_logout_webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login_logout_webapp.model.DAOService;
import com.login_logout_webapp.model.DAOServiceimpl;
import com.mysql.cj.protocol.Resultset;


@WebServlet("/deleteReg")
public class DeleteRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       public DeleteRegistration() {
        super();
        
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email = request.getParameter("email");
			
			DAOService service=new DAOServiceimpl();
			service.connectDB();
			service.deleteRegistration(email);
			
			Resultset result= (Resultset) service.listReg();
			request.setAttribute("result", result);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views//list_all.jsp");
			rd.forward(request, response);

		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
