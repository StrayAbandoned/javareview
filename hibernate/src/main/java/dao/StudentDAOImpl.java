package dao;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import static dao.MyFactory.MySession.sessionFactory;

public class StudentDAOImpl implements StudentDAO{


    @Override
    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Student> Student = session.createQuery("from Student", Student.class).getResultList();
        session.getTransaction().commit();
        return Student;
    }

    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(student);
        session.getTransaction().commit();


    }

    @Override
    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student s = session.get(Student.class, id);
        session.getTransaction().commit();
        return s;
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete from Student where id ="+id).executeUpdate();
        session.getTransaction().commit();
    }
}
