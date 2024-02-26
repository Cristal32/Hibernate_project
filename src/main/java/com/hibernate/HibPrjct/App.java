package com.hibernate.HibPrjct;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

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
        
        Entreprise ese = new Entreprise("429387", "Twitter", "SARL", "126 St.", "0123456789", "Layla", "0987654332");
       
        Configuration config = new Configuration().configure().addAnnotatedClass(Entreprise.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        //Ex1: Ajouter une nouvelle entreprise ============================================
        System.out.println("\nEx1\n");
        //entrepriseId = (String) session.save(ese);
        
        //Ex2: fetch l'entreprise d'id = 429385 ============================================
        System.out.println("\nEx2\n");
        ese = (Entreprise) session.get(Entreprise.class, 429385);
        
        tx.commit();
        
//        if (entrepriseId != null) {
//            System.out.println("New Entreprise added with ID: " + entrepriseId);
//        } else {
//            System.out.println("Failed to add new Entreprise.");
//        }
        
        System.out.println(ese);
        
        
        //Ex3: ================================================================================
        System.out.println("\nEx3\n");
        // 1. get all
        System.out.println("1. Rechercher toutes les lignes de la table Entreprise puis acher les informations obtenues.\n");
        
        List<Entreprise> entreprises = session.createQuery("FROM Entreprise").list();
        for (Entreprise entreprise : entreprises) {
            System.out.println(entreprise);
        }
        System.out.println("\n");
        
        // 2. get entreprise by name
        System.out.println("2. Rechercher une entreprise à partir de son nom puis acher les informations obtenues.\n");
        
        String name = "DXC"; // Example entreprise name
        Query query = session.createQuery("FROM Entreprise WHERE raison_soc = :name");
        query.setParameter("name", name);
        List<Entreprise> results = query.getResultList();
        if (!results.isEmpty()) {
            Entreprise entreprise = results.get(0);
            System.out.println(entreprise);
        } else {
            System.out.println("No entreprise found with the name: " + name);
        }
        System.out.println("\n");
        
        // 3. sort entreprises by forme juridique
        System.out.println("3. Rechercher toutes les lignes de la table Entreprise triées en fonction du nombre d'employés puis acher les informations obtenues.\n");
        
        List<Entreprise> eses = session.createQuery("FROM Entreprise ORDER BY forme_jur").list();
        for (Entreprise entreprise : entreprises) {
            System.out.println(entreprise);
        }
        System.out.println("\n");
        
     // 4. Afficher le nombre de lignes présentes dans la table
        System.out.println("Acher le nombre de lignes présentes dans la table\n");
        
        Long count = (Long) session.createQuery("SELECT COUNT(*) FROM Entreprise").uniqueResult();
        System.out.println("Le nombre de lignes: " + count + "\n");
        
      //Ex4: ================================================================================
        System.out.println("\nEx4\n");
        
        //1. mettre à jour le nom d'une entreprise à partir de son identiant.
        Transaction tx2 = session.beginTransaction();
        String newName = "X"; // New name for the entreprise
        Entreprise entrepriseToUpdate = session.get(Entreprise.class, "429387");
        if (entrepriseToUpdate != null) {
            entrepriseToUpdate.setRaisonSoc(newName);
            session.update(entrepriseToUpdate);
            tx2.commit();
            System.out.println("Entreprise updated successfully.");
        } else {
            System.out.println("Entreprise with ID " + entrepriseId + " not found.");
        }
        System.out.println("\n");
        
        // 2. supprimer une entreprise à partir de son identiant.
        Transaction tx3 = session.beginTransaction();
        Entreprise entrepriseToDelete = session.get(Entreprise.class, "429386");
        if (entrepriseToDelete != null) {
            session.delete(entrepriseToDelete);
            tx3.commit();
            System.out.println("Entreprise deleted successfully.");
        } else {
            System.out.println("Entreprise with ID " + entrepriseId + " not found.");
        }
    }
}
