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
import com.amgen.getResponse.Dao.ProductDAO;
import com.amgen.getResponse.Dao.ProductDAOImpl;
import com.amgen.getResponse.entity.campaign.Channel;
import com.amgen.getResponse.entity.campaign.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		Product product = new Product();
		String productName = request.getParameter("PRODUCTNAME");
		HttpSession session = request.getSession(true);
		try {
			ProductDAO productDAO = new ProductDAOImpl();
			productDAO.addProduct(productName);
			productDAO.fetchData(productName);
			response.sendRedirect("Success");
			System.out.println("added successfully...");
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	}


