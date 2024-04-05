package com.prowings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbDemo {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Student student1 = new Student();
		
		student1.setId(777);
		student1.setName("Narayan");
		student1.setCity("Shiroda");
		
		Certificate certificate1 = new Certificate();
		
		certificate1.setCourse("KW");
		certificate1.setDuration("4 month");
		
		Student student2 = new Student();
		
		student2.setId(999);
		student2.setName("Shatayu");
		student2.setCity("Sawantwadi");
		
		Certificate certificate2 = new Certificate();
		
		certificate2.setCourse("Dinshaws");
		certificate2.setDuration("7 month");
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		// Object save
		
		session.save(student1);
		session.save(student2);
		
		
		tx.commit();
		session.close();
		sf.close();
	}

}
