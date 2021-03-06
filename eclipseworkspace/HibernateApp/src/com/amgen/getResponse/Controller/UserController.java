package com.amgen.getResponse.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amgen.getResponse.Dao.UserDAO;
import com.amgen.getResponse.Dao.UserDAOImpl;
import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.utility.HibernateRepository;
import com.amgen.getResponse.utility.Repository;

/**
 * Servlet implementation class UserCont
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
		User u=new User();
		String userName = request.getParameter("USERNAME");
		String password = request.getParameter("PASSWORD");
		String email = request.getParameter("EMAIL");
		Integer phone = Integer.parseInt(request.getParameter("PHONE"));
		String address = request.getParameter("Address");
		Integer fax = Integer.parseInt(request.getParameter("Fax"));
		String firstname = request.getParameter("First_Name");
		String lastname = request.getParameter("Last_Name");

		HttpSession session = request.getSession(true);
		try {
			UserDAO userDAO = new UserDAOImpl();
			Repository rep = new HibernateRepository();
			userDAO.addUserDetails(userName,password,email,phone,address,firstname,lastname,fax);
			rep.retrieve(User.class); 
			System.out.println("added successfully...");
			response.sendRedirect("success.jsp");
			
          
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
