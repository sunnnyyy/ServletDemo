package com.cache;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernetBasic.Student;

public class FirstCache {
	public static void main(String[] args) {
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session ses = f.openSession();
		

		Student s = ses.get(Student.class, 1);
		System.out.println(s);
		System.out.println("working...");
		
		// by default 1st(session) level caching already enabled it won't call DB again
		Student newS = ses.get(Student.class, 1);
		System.out.println(newS);
		
	}
}
