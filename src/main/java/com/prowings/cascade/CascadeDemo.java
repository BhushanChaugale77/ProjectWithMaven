package com.prowings.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.map.Answer;
import com.prowings.map.Question;

public class CascadeDemo {
	
	public static void main(String[] args) {
		
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	Session session = sessionFactory.openSession();
	
	Question q1 = new Question();
	
	q1.setQuestionId(567);
	q1.setQuestion("What is Cascading...");
	
	Answer a1 = new Answer(45612, "In hibernate it is important concept");
	Answer a2 = new Answer(752, "Second Answer...");
	Answer a3 = new Answer(45, "Third Answer...");
	
	List<Answer> list = new ArrayList<Answer>();
	
	list.add(a1);
	list.add(a2);
	list.add(a3);
	
	q1.setAnswers(list);
	Transaction tx = session.beginTransaction();
	
	session.save(q1);

	
//	session.save(a1);
//	session.save(a2);
//	session.save(a3);
	
	
	
	
	
	session.close();
	sessionFactory.close();
	}

}
