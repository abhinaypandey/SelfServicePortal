package com.amgen.getResponse.Dao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.utility.HibernateRepository;
import com.amgen.getResponse.utility.HibernateUtil;
import com.amgen.getResponse.utility.Repository;

public class UserDAOImpl implements UserDAO{

	public void addUserDetails(String userName, String password, String email,
			int phone, String address, String firstName, String lastName,
			int fax) { 
		try {

			SessionFactory sf= HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Repository rep=new HibernateRepository();
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setAddress(address);
			user.setFax(fax);
			user.setUserName(userName);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhone(phone);
			
			session.save(user);
			rep.retrieve(User.class);
			transaction.commit();
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}

	/* (non-Javadoc)
	 * @see com.amgen.getResponse.Dao.UserDAO#updateUser()
	 */
	@Override
	public void updateUser(String firstname, String lastname, String email,
			int phone, String username, String password, String address, 
			int fax) { 
		// TODO Auto-generated method stub

		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		try{

			transaction = session.getTransaction();
			transaction.begin();
			System.out.println("firstname is"+ firstname);
			Query query = session.createQuery("from User where userName='"+username+"'");
			User user = (User)query.uniqueResult();
			user.getId();
			int id = user.getId();
			System.out.println("before query id is -----"+user.getId());
			User u=(User) session.load(User.class, id);

			u.setFirstName(firstname);
			u.setLastName(lastname);
			u.setEmail(email);
			u.setPhone(phone);
			u.setUserName(username);
			u.setPassword(password);
			u.setAddress(address);

			System.out.println("User records updated!" );
			transaction.commit();
		} catch (HibernateException e) {

			transaction.rollback();
			e.printStackTrace();

		}
	}}





