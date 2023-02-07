package ru.lapshina.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.lapshina.entity.Student;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override

    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> emloyees = session.createQuery("from Student", Student.class).getResultList();
        return emloyees;
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Student where id ="+id).executeUpdate();
    }

    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(student);
    }

    @Override
    public Student getStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }
}
