package com.amgen.getResponse.Controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.utility.HibernateUtil;

public class LoginService {
	public boolean authenticate(String username, String password) {
		 User user = getUserByUsername(username);		
		 if(user!=null && user.getUserName().equals(username) && user.getPassword().equals(password)){
			 return true;
		 }else{
			 return false;
		 }
	}
	
	public User getUserByUsername(String username) {
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;

		 User user = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from User where userName='"+username+"'");
			 user = (User)query.uniqueResult();
			 System.out.println("user name is " + user.getUserName());
			 System.out.println("password is " + user.getEmail() + "first name is" + user.getUserName());
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }
		 return user;
	}

	public List<User> getListOfUsers(){
		 List<User> list = new ArrayList<User>();
		 SessionFactory sf= HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = null;
		 try {
			 tx = session.getTransaction();
			 tx.begin();
			 list = session.createQuery("from User").list();					
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }
		 return list;
	}
	}

