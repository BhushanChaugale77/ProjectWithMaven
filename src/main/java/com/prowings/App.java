package com.prowings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;

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
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started..." );
       
      SessionFactory sf= new Configuration().configure().buildSessionFactory();
      
      //creating student
      Student st = new Student();
      st.setId(99);
      st.setName("Bhau");
      st.setCity("SOLAPUR"); 
      System.out.println(st);
      
      
      //creating object of address class
      Address ad = new Address();
      ad.setStreet("street1");
      ad.setCity("Sangali");
      ad.setOpen(true);
      ad.setX(1234.234);
      
      //Reading Image
      
      FileInputStream fis = new FileInputStream("src/main/java/samrat_prithviraj_chauhan_wikipedia.jpg");
      byte[] data = new byte[fis.available()];
      fis.read(data);
      ad.setImage(data);
      
      Session session = sf.openSession();
      
      Transaction tx = session.beginTransaction();
      session.save(st);
      session.save(ad);
      tx.commit();
      session.close();
      System.out.println("D");
      
      
      
    }
}
     