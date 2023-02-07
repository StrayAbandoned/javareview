package ru.lapshina.service;

import ru.lapshina.entity.Student;

import java.util.List;

public interface Service {

    public List<Student> getAllStudents();

    public void saveStudent(Student employee);

    public Student getStudent(int id);

    public void deleteStudent(int id);
}
