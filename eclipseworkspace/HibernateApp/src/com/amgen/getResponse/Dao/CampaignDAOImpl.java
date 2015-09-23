/**
 * 
 */
package com.amgen.getResponse.Dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.amgen.getResponse.entity.campaign.Campaign;
import com.amgen.getResponse.entity.campaign.Channel;
import com.amgen.getResponse.entity.campaign.Product;
import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.utility.HibernateUtil;



/**
 * @author chaudmee
 *
 */
public class CampaignDAOImpl implements CampaignDAO {

	/* (non-Javadoc)
	 * @see com.amgen.getResponse.Dao.CampaignDAO#addcampaign(java.lang.String)
	 */

	@Override
	public void addcampaign(String campaignName,String productName,String channelName) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sf= HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Product product =new Product();
			Channel channel = new Channel();
			Query query = session.createQuery("select id from Product as p where p.productname='" + productName + "'");
			Long id= (Long) query.uniqueResult();
			Query query1 = session.createQuery("select id from Channel as c where c.channelname='" + channelName + "'");
			Long id1= (Long) query1.uniqueResult();
			System.out.println("select id is---: " + id);
			System.out.println("selected id of channel is---: " + id1);
			product.setId(id);
			channel.setId(id1);
		 	Campaign campaign = new Campaign();
			campaign.setCampaignname(campaignName);
			campaign.setProduct(product);
			campaign.setChannel(channel);
			session.save(campaign);
			System.out.println("-=== saveupdate");
			transaction.commit();


		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}


	/* (non-Javadoc)
	 * @see com.amgen.getResponse.Dao.CampaignDAO#addcampaign(java.lang.String, java.lang.String[], java.lang.String[])
	 */

	//	public void addcampaign(String campaignName, Long productid) {
	// TODO Auto-generated method stub
	/*
		public void addcampaign(String campaignName){
		try {
			SessionFactory sf= HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();

			Campaign campaign1 = new Campaign();
			campaign1.setCampaignname(campaignName);
			//System.out.println("selected value before setting hashset" + productid);

			//product.getId();

			//product.setId(productid);
			Set<Campaign> campaign = new HashSet<Campaign>();
			campaign.add(campaign1);
			Product product = new Product();
			product.setCampaign(campaign);
			//product.setCampaign(campaign);
			//session.save(campaign);
			session.saveOrUpdate(product);
			//session.save(product);
			session.save(campaign1);
			//session.save(campaigns);
			//session.save(campaign1);

			/*	 
	        //Add new Employee object
	        EmployeeEntity emp = new EmployeeEntity();
	        emp.setEmail("demo-user@mail.com");
	        emp.setFirstName("demo");
	        emp.setLastName("user");

	        Set<AccountEntity> accounts = new HashSet<AccountEntity>();
	        accounts.add(account1);
	        accounts.add(account2);

	        emp.setAccounts(accounts);
	        //Save Employee
	        session.save(emp);
			Campaign camp = new Campaign();
			camp.setCampaignname(campaignName);
			Product product1 = new Product();
			product1.setId((long) productid);

		 Set<Campaign> campaign = new HashSet<Campaign>();
		 campaign.add(camp);
		 product1.setCampaign(campaign);

		    transaction.commit();
			System.out.println("\n\n channels Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	 */
	/* 
		public void addcampaign(String campaignName ,String productName){
			try {
				SessionFactory sf= HibernateUtil.getSessionFactory();
				Session session = sf.openSession();
				Transaction transaction = session.beginTransaction();

				Campaign campaign1 = new Campaign();
				campaign1.setCampaignname(campaignName);


				Product product=new Product();
				product.setProductname(productName);

				Set<Campaign> productcampaign = new HashSet<Campaign>();
				productcampaign.add(campaign1);

				product.setCampaign(productcampaign);
				session.saveOrUpdate(product);
				//session.save(product);
				//session.save(product);
				session.save(campaign1);
			    transaction.commit();
				System.out.println("\n\n channels Added \n");

			} catch (HibernateException e) {
				System.out.println(e.getMessage());
				System.out.println("error");
			}

	 */

}

