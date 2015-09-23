package com.amgen.getResponse.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import com.amgen.getResponse.entity.campaign.Channel;
import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.utility.HibernateUtil;

public class ChannelDAOImpl implements ChannelDAO{

	public void addChannel(String channelName)
	{
		try {
			SessionFactory sf= HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Channel ch = new Channel();
			ch.setChannelname(channelName);
			session.save(ch);
			transaction.commit();
			System.out.println("\n\n channels Added \n");
			List<User> users;
			Criteria q=  session.createCriteria(User.class);
			users =   ((Criteria) q).list();
			for (int i = 0; i < users.size(); i++) {
				User u = users.get(i);
				System.out.println(u);
			}

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}
}


