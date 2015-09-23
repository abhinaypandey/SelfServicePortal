/**
 * 
 */
package com.amgen.getResponse.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.utility.HibernateUtil;

/**
 * @author chaudmee
 *
 */
public class LoginDaoImpl1 implements LoginDao1{
	//	public boolean authenticate(String username, String password) {
	//		 User user = getUserByUsername(username);
	//		 System.out.println("username before if loop" + user.getUserName());
	//		 System.out.println("username after " + username);
	//		 if(user!=null && user.getUserName().equals(username) && user.getPassword().equals(password)){
	//			 return true;
	//		 }else{
	//			 return false;
	//		 }
	//	}

	public boolean loginCheck(String username,String password) {
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;


		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User as u where u.userName='" + username + "' and u.password='" + password + "'");
			User user = (User)query.uniqueResult();
			String uname=user.getUserName();
			String pword =user.getPassword();
			System.out.println("username in logincheck " + uname);
			System.out.println("password in logincheck " + pword);
			if(user!=null && user.getUserName().equals(uname) && user.getPassword().equals(pword)){
				return true;
			}else{
				return false;
			}

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;

	}




	//		// TODO Auto-generated method stub
	//		SessionFactory sf= HibernateUtil.getSessionFactory();
	//		Session session = sf.openSession();
	//		Transaction tx = null;
	//
	//		 User user = null;
	//		 try {
	//			 tx = session.getTransaction();
	//			 tx.begin();
	//			 Query query = session.createQuery("from User where userName='"+username+"'");
	//			 user = (User)query.uniqueResult();
	//			 System.out.println("user name is " + user.getUserName());
	//			 System.out.println("password is " + user.getEmail() + "first name is" + user.getUserName());
	//			 tx.commit();
	//		 } catch (Exception e) {
	//			 if (tx != null) {
	//				 tx.rollback();
	//			 }
	//			 e.printStackTrace();
	//		 } finally {
	//			 session.close();
	//		 }
	//		 return user;
	//	}
	//
	//	





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

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
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
}

