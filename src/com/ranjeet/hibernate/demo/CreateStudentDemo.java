package com.ranjeet.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ranjeet.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Creating a new stident object ...");
			
			Student tempStudemt =  new Student("Ranjeet","Singh","ranjee970@gmail.com");
			
			session.beginTransaction();
			
			session.save(tempStudemt);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!!");
		}
		finally {
			factory.close();
		}
	}

}
