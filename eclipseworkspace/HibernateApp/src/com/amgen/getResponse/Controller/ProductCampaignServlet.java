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
import com.amgen.getResponse.Dao.ProductDAO;
import com.amgen.getResponse.Dao.ProductDAOImpl;
import com.amgen.getResponse.entity.campaign.Campaign;
import com.amgen.getResponse.entity.campaign.Product;

/**
 * Servlet implementation class ProductCampaignServlet
 */
@WebServlet("/ProductCampaignServlet")
public class ProductCampaignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductCampaignServlet() {
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
             Campaign campaign =new Campaign();
        String campaignName = request.getParameter("CAMPAIGNNAME");
        String[] productName = request.getParameterValues("select");
		HttpSession session = request.getSession(true);
		try {
			CampaignDAO campaigndao = new CampaignDAOImpl();
		//	campaigndao.addcampaign(campaignName,productName);
			
			response.sendRedirect("Success");
			System.out.println("added successfully...");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

		
		
		
		
		
		
	}


