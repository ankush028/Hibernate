package com.bridgelabz.hibernate.controller;

import com.bridgelabz.hibernate.model.Laptop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateObjectState {
    public static void main(String[] args) throws InterruptedException {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
/*        Laptop laptop = new Laptop();
        laptop.setLapid(52);
        laptop.setLapBrand("Lenovo");
        laptop.setPrice(50000);
        session.save(laptop);
        laptop.setPrice(51000);*/

        Laptop lap = (Laptop) session.load(Laptop.class,51);  //proxy Object

        Thread.sleep(4000);
        System.out.println(lap);
        session.getTransaction().commit();

    }
}
