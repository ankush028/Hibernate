package com.bridgelabz.hibernate.controller;

import com.bridgelabz.hibernate.model.Alien;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateBasics {

    public static void main(String[] args) {

        Alien alien;

        //CACHING  EXAMPLES =-=========>>>>>>>>

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);

        ServiceRegistry serviceRegistry =  new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).buildServiceRegistry();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query q1 = session.createQuery("from Alien where aid=001");
        q1.setCacheable(true);
     //   alien = (Alien) session.get(Alien.class,003);
        alien = (Alien)q1.uniqueResult();
        System.out.println(alien);
        session.getTransaction().commit();
        session.close();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        Query q2 = session1.createQuery("from Alien where aid=001");
        q2.setCacheable(true);
       // alien = (Alien) session1.get(Alien.class,003);
        alien = (Alien)q2.uniqueResult();

        System.out.println(alien);
        session1.getTransaction().commit();
        session1.close();



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
