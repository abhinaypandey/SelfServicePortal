package com.amgen.getResponse.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.amgen.getResponse.Dao.LoginDao1;
import com.amgen.getResponse.Dao.LoginDaoImpl1;
import com.amgen.getResponse.entity.userProfileManagement.User;

/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/LoginServlet1")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");	
		String password = request.getParameter("password");

		LoginDao1 login = new LoginDaoImpl1();
		boolean result=login.loginCheck(username, password);
		System.out.println("result is " + result);
		User user = login.getUserByUsername(username);
		if(result == true){
			request.getSession().setAttribute("user", user);		
			response.sendRedirect("dashboardhome.jsp");

		}
		else{
			request.setAttribute("ErrorMessage", "Sorry,Invalid username/password");
			
			RequestDispatcher dispatcher =  request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			
		}




	}

}
