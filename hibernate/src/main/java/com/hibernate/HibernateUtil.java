package com.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.entities.Student;

public class HibernateUtil {

	private static SessionFactory sessionfactory;

	public static SessionFactory getSessionFactory() {

		if (sessionfactory == null) {
			Configuration cfg = new Configuration();

			Properties settings = new Properties();
			settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/sample?useSSL=false");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "root");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			settings.put(Environment.SHOW_SQL, "true");
			settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			//settings.put(Environment.HBM2DDL_AUTO, "create-drop");
			cfg.setProperties(settings);
			cfg.addAnnotatedClass(Student.class);

			ServiceRegistry sg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			sessionfactory = cfg.buildSessionFactory(sg);
		}
		return sessionfactory;

	}

}
