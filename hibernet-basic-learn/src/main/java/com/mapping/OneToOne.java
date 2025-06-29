package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOne {
	public static void main(String[] args) {

		Configuration cf = new Configuration().configure();
		SessionFactory factory = cf.buildSessionFactory();
		Session ses = factory.openSession();
		
//		Question ques = new Question();
//		Answer ans = new Answer();
//		
//		Transaction tx = ses.beginTransaction();
//		
//		ques.setQuestion("What is java.?");
//		ans.setAnswer("Java is a programming language...");
//		ques.setAnswer(ans);
//		ses.save(ques);
//		ses.save(ans);
//		
//		Question ques1 = new Question();
//		Answer ans1 = new Answer();
//		ques1.setQuestion("What is c++.?");
//		ans1.setAnswer("c++ is a programming language...");
//		ques1.setAnswer(ans1);
//		ses.save(ques1);
//		ses.save(ans1);
		
		Question q = (Question)ses.load(Question.class, 3);
		Answer a = (Answer)ses.load(Answer.class, 3);
		System.out.println(q.getQuestion());
		System.out.println(a.getAnswer());
		
		
//		tx.commit();
		ses.close();
		factory.close();
		
	}
}
