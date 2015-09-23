package com.amgen.getResponse.Dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.amgen.getResponse.entity.campaign.Campaign;
import com.amgen.getResponse.entity.campaign.Channel;
import com.amgen.getResponse.entity.campaign.Product;
import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.utility.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {

	public void addProduct(String productName){
		try {
			SessionFactory sf= HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Product product = new Product();
			product.setProductname(productName);
			
			session.save(product);
			transaction.commit();
			System.out.println("\n\n products Added \n");




		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}

	/* (non-Javadoc)
	 * @see com.amgen.getResponse.Dao.ProductDAO#fetchData(java.lang.String)
	 */
	@Override
	public List<Product> fetchData(String productName) {
		// TODO Auto-generated method stub
		try {
			SessionFactory sf= HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Product product = new Product();
			List<Product> products;
			Criteria q=  session.createCriteria(Product.class);
			products =   ((Criteria) q).list();
			session.getTransaction().commit();
			System.out.println("products are:"+ products.size());
            System.out.println("product names are:" + products.get(0).getProductname());
			return products;
		}catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
		return null;
		
		
		
}}






