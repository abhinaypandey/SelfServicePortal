package com.amgen.getResponse.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amgen.getResponse.Dao.CampaignDAO;
import com.amgen.getResponse.Dao.CampaignDAOImpl;
import com.amgen.getResponse.Dao.UserDAO;
import com.amgen.getResponse.Dao.UserDAOImpl;
import com.amgen.getResponse.entity.campaign.Campaign;
import com.amgen.getResponse.entity.campaign.Channel;
import com.amgen.getResponse.entity.campaign.Product;
import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.utility.HibernateRepository;
import com.amgen.getResponse.utility.Repository;

/**
 * Servlet implementation class ChannelCampServlet
 */
@WebServlet("/ChannelCampServlet")
public class ChannelCampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChannelCampServlet() {
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
		Campaign camp = new Campaign();
		String campaignName = request.getParameter("CAMPAIGNNAME");
		System.out.println("canpaign name is " + campaignName);

		Integer pid = Integer.parseInt(request.getParameter("select"));
		Long productid = pid.longValue();
		System.out.println("selected product is--" + productid);
	
		
//		String[] p = request.getParameterValues ("select");
//		for (int i=0;i<p.length;i++) {
//			System.out.println ("VALUE = "+p[i]);
//		}
//		List<String> list = Arrays.asList(p);
//		System.out.println("arraylist is " + list);

        Channel channel1 =new Channel();
        Channel channel2 =new Channel();

        	int channelid1	=Integer.parseInt(request.getParameter("ChannelList"));
        	 channel1.setId((long) channelid1);
		String[] c=request.getParameterValues ("ChannelList");
		Set<String> s = new HashSet<String>(Arrays.asList(c));
		System.out.println("before for loop");
		System.out.println("selected channels are " + s);

		HttpSession session = request.getSession(true);
		try {
			CampaignDAO campaigndao = new CampaignDAOImpl();
			Repository rep = new HibernateRepository();
			//campaigndao.addcampaign(campaignName);
	        System.out.println("added successfully...");
			response.sendRedirect("Success");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}






