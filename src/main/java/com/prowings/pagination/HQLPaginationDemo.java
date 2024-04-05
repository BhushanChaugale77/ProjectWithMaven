package com.prowings.pagination;

import org.hibernate.query.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prowings.Student;

public class HQLPaginationDemo {

	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Query query =session.createQuery("from Student");
		
		// implementing pagination using Hibernate
		
		query.setFirstResult(10);
		
		query.setMaxResults(5);
		
		List<Student> list = query.list();
		
		for(Student st : list) 
		{
			System.out.println(st.getId() + " : " + st.getName() + " : "+ st.getCity());
		}
		
		session.close();
		sessionFactory.close();
	}
	
	
}
