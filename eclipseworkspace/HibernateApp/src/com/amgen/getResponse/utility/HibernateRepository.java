/**
 * 
 */
package com.amgen.getResponse.utility;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.amgen.getResponse.entity.campaign.Channel;
import com.amgen.getResponse.entity.campaign.Product;
import com.amgen.getResponse.entity.campaign.UserSubscription;
import com.amgen.getResponse.entity.userProfileManagement.User;

/**
 * @author chaudmee
 *
 */
public class HibernateRepository implements Repository{
	private List<User> users;
	private List<Product> products;
	private List<Channel> channels;
	private List<UserSubscription> userdata;
	/* (non-Javadoc)
	 * @see com.amgen.getResponse.utility.Repository#retrieve(java.lang.Class)
	 */
	@Override
	public Object retrieve(Class<User> user) {
		// TODO Auto-generated method stub
		try {

			SessionFactory sf= HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria q=  session.createCriteria(User.class);
			users =   ((Criteria) q).list();
			for (int i = 0; i < users.size(); i++) {
				User u = users.get(i);
				System.out.println(u.getUserName());
			}

			session.getTransaction().commit();

		}catch(HibernateException e){
			System.out.println("error");
		}
		return users;
	}

	/* (non-Javadoc)
	 * @see com.amgen.getResponse.utility.Repository#fetchData()
	 */
	@Override
	public List<Product> fetchData() {
		
		// TODO Auto-generated method stub
		try {

			SessionFactory sf= HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria q=  session.createCriteria(Product.class);
			// products = (Criteria) q.uniqueResult();
			q.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			products =   ((Criteria) q).list();
			for (int i = 0; i < products.size(); i++) {
				Product p = products.get(i);
				System.out.println(p.getProductname());
			}

			session.getTransaction().commit();
			System.out.println("products are:"+ products);

		}catch(HibernateException e){
			System.out.println("error");
		}
		return products;
	}

	/* (non-Javadoc)
	 * @see com.amgen.getResponse.utility.Repository#fetchChannel()
	 */
	@Override
	public List<Channel> fetchChannel() {
		// TODO Auto-generated method stub
		try {

			SessionFactory sf= HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria q=  session.createCriteria(Channel.class);
			q.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			channels =   ((Criteria) q).list();
			for (int i = 0; i < channels.size(); i++) {
				Channel c = channels.get(i);
				System.out.println(c.getChannelname());
			}

			session.getTransaction().commit();
			System.out.println("channels are:"+ channels);

		}catch(HibernateException e){
			System.out.println("error");
		}
		return channels;
	}

	/* (non-Javadoc)
	 * @see com.amgen.getResponse.utility.Repository#fetchUserData()
	 */
	@Override
	public List<UserSubscription> fetchUserData() {
		// TODO Auto-generated method stub
		try {

			SessionFactory sf= HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Criteria q=  session.createCriteria(UserSubscription.class);
			userdata =   ((Criteria) q).list();
			
			for (int i = 0; i < userdata.size(); i++) {
				UserSubscription c = userdata.get(i);
				System.out.println(c.getChannelname());
			}
			session.getTransaction().commit();

		}catch(HibernateException e){
			e.printStackTrace();
		}
		return userdata;
	}

}
