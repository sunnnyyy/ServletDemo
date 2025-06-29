package com.mapping1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToMany {
	public static void main(String[] args) {

		try {
			Configuration cf = new Configuration().configure();
			SessionFactory factory = cf.buildSessionFactory();
			Session ses = factory.openSession();

			Transaction tx = ses.beginTransaction();

			Employe e1 = new Employe();
			Project p1 = new Project();
			e1.setName("emp 1");
			p1.setName("project 1");

			Employe e2 = new Employe();
			Project p2 = new Project();
			e2.setName("emp 2");
			p2.setName("Project 2");

			List<Employe> el = new ArrayList<Employe>();
			List<Project> pl = new ArrayList<Project>();
			el.add(e1);
			el.add(e2);
			pl.add(p1);
			pl.add(p2);
			
			e1.setProject(pl);
			p1.setEmploye(el);
			
			ses.save(e1);
			ses.save(e2);
			ses.save(p1);
			ses.save(p2);

			tx.commit();
			ses.close();
			factory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
