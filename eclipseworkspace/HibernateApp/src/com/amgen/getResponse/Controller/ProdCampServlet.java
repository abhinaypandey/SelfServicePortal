package com.amgen.getResponse.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amgen.getResponse.Dao.CampaignDAO;
import com.amgen.getResponse.Dao.CampaignDAOImpl;
import com.amgen.getResponse.entity.campaign.Campaign;
import com.amgen.getResponse.utility.HibernateRepository;
import com.amgen.getResponse.utility.Repository;

/**
 * Servlet implementation class ProdCampServlet
 */
@WebServlet("/ProdCampServlet")
public class ProdCampServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdCampServlet() {
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
		Campaign campaign = new Campaign();
		String campaignName = request.getParameter("CAMPAIGNNAME");
		String productName =  request.getParameter("select");
		String channelName =  request.getParameter("selectchannel");
		System.out.println("campaign name is " + campaignName);
		System.out.println("product name is " + productName);
		System.out.println("channel name is " + channelName);
        HttpSession session = request.getSession(true);
		try {
			CampaignDAO campaigndao = new CampaignDAOImpl();
			Repository rep = new HibernateRepository();
			campaigndao.addcampaign(campaignName ,productName,channelName);
	        System.out.println("added successfully...");
			response.sendRedirect("Success");

		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}



		
		
		
		
	}


