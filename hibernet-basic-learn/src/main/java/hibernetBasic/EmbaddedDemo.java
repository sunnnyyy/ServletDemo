package hibernetBasic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbaddedDemo {
	public static void main(String[] args) {

		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cf.buildSessionFactory();
		Session ses = factory.openSession();

		Student s = new Student();
		s.setCity("noida");
		s.setName("nirbhay");

		Certificate c = new Certificate();
		c.setCourse("bca");
		c.setDuration("3 years");
		s.setCerti(c);

		Transaction tx = ses.beginTransaction();
		ses.save(s);

		tx.commit();
		ses.close();
		factory.close();
	}
}
