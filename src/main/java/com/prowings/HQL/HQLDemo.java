package com.prowings.HQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.Student;



public class HQLDemo {

	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		
		//HQL
		//Syntsx
		
		String query ="from Student as s where s.city=:x and s.name =:n";
		
		Query q=session.createQuery(query);
		
		q.setParameter("x","Sawantwadi");
		q.setParameter("n", "Shatayu");
		
		//single - (Unique)
		//multiple - list
		List<Student> list = q.list();
		
		for(Student student:list)
		{
			System.out.println(student.getName()+" : "+student.getCerti().getCourse());
		}
		
		System.out.println("-------------------------------------------");
		
		Transaction tx = session.beginTransaction();
//		delete query
//		Query q2 = session.createQuery("delete from Student s where city =:c");
//		q2.setParameter("c", "Narayan");
//		int r = q2.executeUpdate();
//		System.out.println("Deleted");
//		System.out.println(r);
		
//		Update query
		Query q2=session.createQuery("update Student set city=:c where name=:n");
		q2.setParameter("c", "Goa");
		q2.setParameter("n", "Sanyogita");
		int r = q2.executeUpdate();
		System.out.println(r + "objects updated");
		
		tx.commit();
		
		//how to execute join query
		Query q3 =session.createQuery("select q.question,q.questionId,a.answer from Question as q inner join q.answers as a");
		
		List<Object []> list3  = q3.getResultList();
		
		for(Object[] arr : list3) {
			System.out.println(Arrays.toString(arr));	
		}
		
		session.close();
		sessionFactory.close();
		
	}
	
}
