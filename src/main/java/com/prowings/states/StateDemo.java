package com.prowings.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.Certificate;
import com.prowings.Student;

public class StateDemo {

	public static void main(String[] args) {
		
		//practical of Hibernate Object States
		//Transient
		//Persistent
		//Detached
		//Removed
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		
		//creating Student Object
		
		Student student = new Student();
		student.setId(77);
		student.setName("ABC");
		student.setCity("Lavasa");
		student.setCerti(new Certificate("JAVA", "9 Months"));
		
//		Certificate certi = new Certificate();
//		certi.setCourse("JAVA");
//		certi.setDuration("9 months");
		
		//Student : Transient  
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		
		//Student : Persistent - Session, DataBase
		
		student.setName("John");
		tx.commit();
		
		session.close();
		
		student.setName("Sachin");
		
		//Student : Detached
		System.out.println(student);
		
		
		
		
		sessionFactory.close();
	}
	
	
	
}
