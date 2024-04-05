package com.prowings.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	//	creating Question
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java?");

	//	creating Answer

		Answer ans = new Answer();
		ans.setAnswerId(343);
		ans.SetAnswer("Java is Programing Language");
		ans.setQuestion(q1);
	//	q1.setAnswer(ans);

	//	creating Question
		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What is Collection Framework?");

	//	creating Answer

		Answer ans1 = new Answer();
		ans1.setAnswerId(344);
		ans1.SetAnswer("Collection Framework is an API to work with java objects");
		ans.setQuestion(q2);
	//	q2.setAnswer(ans1);

		// session

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		//save
		
		session.save(q1);
		session.save(q2);
		session.save(ans);
		session.save(ans1);
		
		
		
//		//fetching
//		Question newQ = (Question)session.get(Question.class, 1212);
//		System.out.println(newQ.getQuestionId());
//		System.out.println(newQ.getQuestion());
//		
//		//Lazy
//		System.out.println(newQ.getAnswers().size());
		
		
		tx.commit();
		session.close();
		
		
		sessionFactory.close();
		
	}

}
