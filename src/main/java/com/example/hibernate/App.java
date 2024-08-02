package com.example.hibernate;

import java.util.Scanner;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.archive.internal.StandardArchiveDescriptorFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
//        Configuration con = new Configuration().configure("hibernate.cfg.xml");//to connect the mysql(database)
//        
//        SessionFactory sf = con.buildSessionFactory();//create database
//        
//        Session s = sf.openSession();//create elements in database
//        
//        s.beginTransaction();//to begin the data 
//        
//        s.save(s);//to save the data
//        
//        s.getTransaction().commit(); //to check the final output

		Configuration con = new Configuration().configure("hibernate.cfg.xml");
		
		Scanner scr = new Scanner(System.in);
		
		

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();

		Metadata mt = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sf = con.buildSessionFactory();

		Session s = sf.openSession();

		Transaction t = s.beginTransaction();

		hibernate h = new hibernate();

		h.setName("sandy");

		h.setEmail("sandy@123");

		h.setPassword("root");

		h.setBranch("ECE");

		s.save(h);

		t.commit();

		System.out.println("successfully inserted");

		sf.close();

		s.close();
	}
}
