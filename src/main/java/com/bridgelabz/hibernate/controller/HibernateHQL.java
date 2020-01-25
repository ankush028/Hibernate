package com.bridgelabz.hibernate.controller;

import com.bridgelabz.hibernate.model.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HibernateHQL {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory =     configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        //USING SQL QUERY---->>>>>>>>
      /*  Random random = new Random();

        for (int i=5;i<=50;i++){
            Student student = new Student();
            student.setName("Name"+i);
            student.setRollNo(i);
            student.setMarks(random.nextInt(100));
            session.save(student);
        }*/
    // FETCH DATA FROM DATABASE USING HIBERNATE QUERY LANGUAGE======>>>>>>>>>>>>.
        /*Query q = session.createQuery("from Student where marks>50");
        List<Student> listOfStudents = q.list();

        listOfStudents.forEach((k)-> System.out.println(k));*/



        //AGGREGATE FUNCTIONS========>>>>>>>>>>>>.
       /* Query query = session.createQuery("select sum(marks) from Student s where s.marks>50");
        Long marks = (Long) query.uniqueResult();
        System.out.println  (marks);*/



        //   Query query= session.createQuery("select rollNo,marks,name from Student where rollNo=15");
       // Object[] student = (Object[])query.uniqueResult();

     //   for (Object o: student){
         //   System.out.println(student[0]+""+student[1]+""+student[2]);
       // }

        //NATIVE QUERIES ======================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //    SQLQuery sqlQuery = session.createSQLQuery("select*from Student where marks>50");
        SQLQuery sqlQuery = session.createSQLQuery("select name,marks from Student where marks>50");
        sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

       // sqlQuery.addEntity(Student.class);
        List<Student> students = sqlQuery.list();
        for (Object o:students){
            Map m = (Map)o;
            System.out.println(m.get("name")+" : "+m.get("marks"));
        }

        session.getTransaction().commit();

    }
}
