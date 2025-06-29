package hibernetBasic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetData {
public static void main(String[] args) {
	
    Configuration cf= new Configuration().configure("hibernate.cfg.xml");
  	SessionFactory factory = cf.buildSessionFactory();
  	Session ses = factory.openSession();
  	
  	Student s = (Student)ses.load(Student.class, 2);//faster than get
  	Address ad = (Address)ses.get(Address.class, 2);
	System.out.println(s);
	System.out.println(ad.getCity());
	}  	
  	
  	
  	
}
