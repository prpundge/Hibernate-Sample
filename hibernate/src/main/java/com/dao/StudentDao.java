package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.entities.Student;
import com.hibernate.HibernateUtil;

public class StudentDao {
	public void saveStudent(Student s) {
		Transaction t;
		Session session = HibernateUtil.getSessionFactory().openSession();
		t = session.beginTransaction();
		session.save(s);
		t.commit();

	}

	public List<Student> getstudent() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Criteria c=session.createCriteria(Student.class);
		//c.add(Restrictions.eqOrIsNull("name", "pravsdsdin1"));
		//c.setFirstResult(1);
		//c.setMaxResults(2);
		Query c=session.createQuery("from Student",Student.class);
		//c.setProjection(Projections.rowCount());
		System.out.println(c.list());
		return c.list();
	}

}
