package com.prowings.aql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.prowings.Student;

public class SQLQueryDemo {

	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		//SQL Query
		
		String query = "Select * from Student";
		
		NativeQuery nq = session.createSQLQuery(query);
		
		List<Student> list=nq.list();
		
		for(Student student : list)
		{
			System.out.println(student.getName() +" : "+ student.getCity());
		}
		
		
		
		session.close();
		sessionFactory.close();
	}
}
