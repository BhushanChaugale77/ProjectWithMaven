package com.prowings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		
		//get or load
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		//get student 99
		
		 Student st =(Student)session.load(Student.class, 99);
		 Student st1 =(Student)session.load(Student.class, 99);
		 
		 System.out.println(st.getName());
		
//		Address ad = (Address)session.get(Address.class, 1);
//		System.out.println(ad.getStreet()+ " : "+ad.getCity());
//		
//		Address ad1 = (Address)session.get(Address.class, 1);
//		System.out.println(ad1.getStreet()+ " : "+ad1.getCity());
		
		
		
		session.close();
		sf.close();
		
	}
	
	
}
