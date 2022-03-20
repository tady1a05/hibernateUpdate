package com.toby.saveJdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.toby.model.Student;


public class JdbcSave {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = null;

		try {
			session = sessionFactory.getCurrentSession();
			
			String studentId = "1";
			
			session.beginTransaction();
									
			Student student1 = session.get(Student.class, studentId);
			
			student1.setFirstName("Jolly");
			
			session.getTransaction().commit();
			
			session = sessionFactory.getCurrentSession();

			session.beginTransaction();
			
			session.createQuery("update Student set email = 'nmsl@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
		}finally {
			sessionFactory.close();
		}
	
	}

}
