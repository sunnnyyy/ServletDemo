package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import hibernetBasic.Student;

public class HQLClass {
	public static void main(String[] args) {
		Configuration cf = new Configuration().configure();
		SessionFactory factory = cf.buildSessionFactory();
		Session ses = factory.openSession();

//		String sql = "select * from student"; // from mysql table
//		NativeQuery q = ses.createSQLQuery(sql); // Query q also can be use
//		String hql = "FROM Student";
		String hql = "FROM Student where name=:name and city=:city";
		// NOTE: table name will be here class name Student and column name will be here
		// instance var
		Query query = ses.createQuery(hql);
		query.setParameter("name", "sunny");
		query.setParameter("city", "patna");
		// Execute and get result list
//		query.setFirstResult(0);// for pagination
//		query.setMaxResults(5); // max 5 records will be fetched
		
		List<Student> students = query.list();
		
		// Print or use the result
		for (Student student : students) {
			System.out.println(student.getName());
		}

		Transaction tx = ses.beginTransaction();

		hql = "update Student set name=:curname where name=:upname";
		Query q2 = ses.createQuery(hql);
		q2.setParameter("curname", "nirbhay");
		q2.setParameter("upname", "dev");
		int updatedRowCount = q2.executeUpdate();

		System.out.println(updatedRowCount);
		tx.commit();

		hql = "select q.id, q.question from Question q INNER JOIN Answer a on a.id = q.answer ";
		Query q3 = ses.createQuery(hql);
		List<Object[]> res = q3.list();
		for (Object[] obj : res) {
			System.out.println(Arrays.toString(obj));
		}
		ses.clear();
		factory.close();
	}
}
