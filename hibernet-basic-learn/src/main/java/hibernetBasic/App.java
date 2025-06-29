package hibernetBasic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    private static FileInputStream fis;

	public static void main( String[] args ) throws IOException
    {
    	Configuration cf= new Configuration().configure();
//    OR	Configuration cf= new Configuration().configure("hibernate.cfg.xml");
    	SessionFactory factory = cf.buildSessionFactory();
    	System.out.println(factory.isClosed());
    	Session ses = factory.openSession();
    	
    	Student s = new Student();
//    	s.setId(4);
    	s.setName("kd");
    	s.setCity("bihta");
    	
    	//creating address obj
    	
    	Address ad = new Address();
    	ad.setCity("bihta");
    	ad.setState("bihar");
    	ad.setAddedDate(new Date());
    	ad.setOpen(true);
    	ad.setX(1); // it won't save or create any column bcz we avoid in class by using @Transient
    	fis = new FileInputStream("src/main/java/pic.jpg");
    	byte[] data = new byte[fis.available()];
    	fis.read(data);
    	ad.setImage(data);
    	
    	Transaction t = ses.beginTransaction();
    	ses.save(s);
    	ses.save(ad);
    	t.commit();
    	ses.close();
    	
    	factory.close();
    	
    }
}
