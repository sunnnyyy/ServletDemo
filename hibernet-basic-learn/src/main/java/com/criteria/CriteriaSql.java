package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import hibernetBasic.Student;

public class CriteriaSql {
	public static void main(String[] args) {
		Session ses = new Configuration().configure().buildSessionFactory().openSession();
	
		Criteria c = ses.createCriteria(Student.class);
		c.add(Restrictions.eq("name", "sunny"));

		List<Student> l = c.list();
		
		System.out.println(l);
		
		
	}
}
