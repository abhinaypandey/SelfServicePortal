package com.amgen.getResponse.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amgen.getResponse.Dao.CampaignDAO;
import com.amgen.getResponse.Dao.CampaignDAOImpl;
import com.amgen.getResponse.entity.campaign.Channel;
import com.amgen.getResponse.entity.campaign.Product;
import com.amgen.getResponse.utility.HibernateRepository;

/**
 * Servlet implementation class AddCampaign
 */
@WebServlet("/AddCampaign")
public class AddCampaign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCampaign() {
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
		HibernateRepository hr =new HibernateRepository();
		HttpSession session = request.getSession(false);
		try {
			Product p=new Product();
			List <Product> list =  hr.fetchData();
            for (int i = 0; i < list.size(); i++) {
				p =  list.get(i);
				
			}
		
			System.out.println("first product is " + list.get(0).getProductname());
			//System.out.println("second product is " + list.get(1).getProductname());
			request.getSession().setAttribute("productList", list);
			
		    Channel c=new Channel();
			List <Channel> list1 =  hr.fetchChannel();
            for (int i = 0; i < list1.size(); i++) {
				c =  list1.get(i);
				
			}
			
			System.out.println("first channel is " + list1.get(0).getChannelname());
			System.out.println("second channel is " + list1.get(1).getChannelname());
			request.getSession().setAttribute("channelList", list1);
			request.getRequestDispatcher("/addCampaign.jsp").forward(request, response);
			//request.getRequestDispatcher("/home.jsp").forward(request, response);
            System.out.println("before dispatcher" + list);
            //System.out.println("before dispatcher" + list1);
			System.out.println("added successfully...");
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	
}
