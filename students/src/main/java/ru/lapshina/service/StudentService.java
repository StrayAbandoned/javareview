package ru.lapshina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import ru.lapshina.dao.StudentDAO;
import ru.lapshina.entity.Student;


import java.util.List;
@org.springframework.stereotype.Service
@EnableTransactionManagement(proxyTargetClass = true)
public class StudentService implements Service{
    @Autowired
    private StudentDAO studentDAO;
    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return  studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }
}
