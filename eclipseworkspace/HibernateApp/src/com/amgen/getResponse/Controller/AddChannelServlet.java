package com.amgen.getResponse.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amgen.getResponse.Dao.ChannelDAO;
import com.amgen.getResponse.Dao.ChannelDAOImpl;
import com.amgen.getResponse.Dao.UserDAO;
import com.amgen.getResponse.Dao.UserDAOImpl;
import com.amgen.getResponse.entity.campaign.Channel;

/**
 * Servlet implementation class AddChannelServlet
 */
@WebServlet("/AddChannelServlet")
public class AddChannelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddChannelServlet() {
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
		Channel ch = new Channel();
		String channelName = request.getParameter("CHANNELNAME");
		HttpSession session = request.getSession(true);
		try {
			ChannelDAO channelDAO = new ChannelDAOImpl();
			channelDAO.addChannel(channelName);
			response.sendRedirect("Success");
			System.out.println("added successfully...");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}


