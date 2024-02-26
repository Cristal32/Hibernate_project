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
    	String entrepriseId = null;
    	
        System.out.println( "Hello World!" );
        
        Entreprise ese = new Entreprise("429384", "DXC", "SARL", "123 St.", "0123456789", "Safae", "0987654332");
       
        Configuration config = new Configuration().configure().addAnnotatedClass(Entreprise.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        //Ex1: Ajouter une nouvelle entreprise
//        entrepriseId = (String) session.save(ese);
        
        //Ex2: fetch l'entreprise d'id = 429385
        ese = (Entreprise) session.get(Entreprise.class, 429385);
        
        tx.commit();
        
//        if (entrepriseId != null) {
//            System.out.println("New Entreprise added with ID: " + entrepriseId);
//        } else {
//            System.out.println("Failed to add new Entreprise.");
//        }
        
        System.out.println(ese);
        
        
    }
}
