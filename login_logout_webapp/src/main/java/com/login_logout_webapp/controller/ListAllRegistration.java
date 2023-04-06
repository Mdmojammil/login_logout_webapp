
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
import com.mysql.cj.protocol.Resultset;


@WebServlet("/ListAllRegistration")
public class ListAllRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       public ListAllRegistration() {
        super();
           }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			DAOService service=new DAOServiceimpl();
			service.connectDB();
			
			HttpSession session=request.getSession(false);
			if(session.getAttribute("email")!=null) {
			
			Resultset result= (Resultset) service.listReg();
			request.setAttribute("result", result);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views//list_all.jsp");
			rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);

			}
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

}
