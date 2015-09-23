package com.amgen.getResponse.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amgen.getResponse.Dao.LoginDao1;
import com.amgen.getResponse.Dao.LoginDaoImpl1;
import com.amgen.getResponse.entity.campaign.Product;
import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.utility.HibernateRepository;
import com.amgen.getResponse.utility.Repository;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
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
		
		LoginDao1 logindao = new LoginDaoImpl1();
		HttpSession session = request.getSession(false);
		try {
			
			User user= (User) session.getAttribute("user");
			System.out.println("username is ===========" + user.getUserName());
			String username=user.getUserName();
			logindao.getUserByUsername(username);
			user.getFirstName();
			user.getLastName();
			user.getAddress();
			user.getEmail();
			user.getFax();
			user.getPassword();
			user.getPhone();
			user.getUserName();
		
			//System.out.println("first name is " + users.get(0).getFirstName());
			//System.out.println("second product is " + list.get(1).getProductname());
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/editProfile.jsp").forward(request, response);
	}catch(Exception e)
	{
		e.printStackTrace();
	}

}
}