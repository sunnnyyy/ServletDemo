package com.xml.mapping.table;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// create without entity only xml bases mapping to table
public class XmlMappingTable {
	public static void main(String[] args) {
		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session ses = f.openSession();
		
		Person p = new Person(1, "sunny");
		Transaction tx = ses.beginTransaction();
		ses.save(p);
		tx.commit();
		ses.close();
		f.close();
		
	}
}
