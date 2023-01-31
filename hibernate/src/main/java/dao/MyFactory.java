package dao;

import entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyFactory {
    static class MySession{
        static SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
    }
}
