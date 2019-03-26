package com.bridgeit.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.bridgeit.model.LoginInfo;
import com.bridgeit.model.PasswordInfo;
import com.bridgeit.model.User;


public class LoginUserDao implements UserDao 
{
	
	public int addUser(User user) 
	{
		Configuration config = new Configuration().configure().addAnnotatedClass(User.class);
		
		SessionFactory sessionFactory = config.buildSessionFactory();
	    Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		System.out.println(user);
		return 0;
		
	}

	
	public boolean checkUserIsPresent(LoginInfo login) 
	{
		boolean isValidUser = false;
		User user = null;
		Configuration config = new Configuration().configure().addAnnotatedClass(User.class);
		  @SuppressWarnings("deprecation")
		  SessionFactory sessionFactory=config.buildSessionFactory();
		  Session session=sessionFactory.openSession();
	        String hql="from User where email=? and password=?";
	        try
	        {
	            Query query=session.createQuery(hql);
	            query.setParameter(0,login.getEmail());
	            query.setParameter(1,login.getPassword());
	            user = (User)query.uniqueResult();
	            if(user != null)
	            	isValidUser = true;
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally{
	            session.close();
	        }
	        return isValidUser;
        
	}
	public boolean checkIsUserEmailPresent(PasswordInfo passwordEmail)
	{
		boolean isValidUser = false;
		User user = null;
		Configuration config = new Configuration().configure().addAnnotatedClass(User.class);
		  @SuppressWarnings("deprecation")
		  SessionFactory sessionFactory=config.buildSessionFactory();
		  Session session=sessionFactory.openSession();
	        String hql="from User where email=? ";
	        try
	        {
	            Query query=session.createQuery(hql);
	            query.setParameter(0,passwordEmail.getEmail());
	            user = (User)query.uniqueResult();
	            if(user != null)
	            	isValidUser = true;
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	        finally{
	            session.close();
	        }
	        return isValidUser;	
	        }
	}