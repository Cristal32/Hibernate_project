package com.hibernate.HibPrjct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String entrepriseId = "";
    	
        System.out.println( "Hello World!" );
        
        Entreprise ese = new Entreprise("429385", "Orange", "SARL", "124 St.", "0123456789", "Hamza", "0987654332");
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Entreprise.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        entrepriseId = (String) session.save(ese);
        //session.save(ese);
        tx.commit();
        
        if (entrepriseId != null) {
            System.out.println("New Entreprise added with ID: " + entrepriseId);
        } else {
            System.out.println("Failed to add new Entreprise.");
        }
    }
}
