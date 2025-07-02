package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping1.Employe;

public class SecondLevelCache {
	public static void main(String[] args) {
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session ses = f.openSession();
		
		Employe e = ses.get(Employe.class, 1);
		System.out.println(e);
		ses.close();
		
		
		Session ses1 = f.openSession();
		// it will call from cache bcz here we're added second level cache which is factory level and level cache is only session level which is by default enabled
		Employe e1 = ses1.get(Employe.class, 1);
		System.out.println(e1);
		
		ses1.close();
		
	}
}
