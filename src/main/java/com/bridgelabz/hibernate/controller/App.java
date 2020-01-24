package com.bridgelabz.hibernate.controller;

import com.bridgelabz.hibernate.model.Alien;
import com.bridgelabz.hibernate.model.FullName;
import com.bridgelabz.hibernate.model.Laptop;
import com.bridgelabz.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {

    public static void main(String[] args) {

        Alien alien;
        //CACHING  EXAMPLES =-=========>>>>>>>>


        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);

        ServiceRegistry serviceRegistry =  new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).buildServiceRegistry();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        alien = (Alien) session.get(Alien.class,001);
        System.out.println(alien);
      //  System.out.println(session.get(Alien.class,002));

        session.getTransaction().commit();
        session.close();


        //FIRST EXAMPLE --->>>>LEARNING HIBERNATE
/*

        Alien bridge= new Alien();
        FullName fn = new FullName();
        fn.setFname("Mayuresh");
        fn.setMname("Kumar");
        fn.setLname("Sonar");

        bridge.setAid(005);
        bridge.setName(fn);
        bridge.setColor("Blue");


        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);

        ServiceRegistry serviceRegistry =  new ServiceRegistryBuilder()
                                    .applySettings(configuration.getProperties()).buildServiceRegistry();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
      //bridge = (Alien) session.get(Alien.class,002);
        session.save(bridge);
        transaction.commit();
*/


                  //SECOND EXAMPLE =======>>>>>>> MAPPING

       /* Laptop laptop = new Laptop();

        laptop.setLapid(101);
        laptop.setLapName("HP");

        Student student = new Student();
        student.setName("Ankush");
        student.setMarks(100);
        student.setRollNo(101);
        student.getLaptops().add(laptop);


        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class)
                                                                        .addAnnotatedClass(Laptop.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                                                 .buildServiceRegistry();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(laptop);
        session.save(student);
        session.getTransaction().commit();*/
    }

}
