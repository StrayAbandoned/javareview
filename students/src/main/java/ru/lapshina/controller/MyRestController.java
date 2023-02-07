package ru.lapshina.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lapshina.entity.Student;
import ru.lapshina.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
@ResponseBody
@WebServlet
public class MyRestController extends HttpServlet {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public void showStudents(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Student> students = service.getAllStudents();
        req.setAttribute("students", students);
        req.getRequestDispatcher("students.jsp").forward(req, res);
    }

    @GetMapping("/students/{id}")
    public void getStudent(@PathVariable int id, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Student student = service.getStudent(id);
        req.setAttribute("name", student.getName());
        req.setAttribute("age", student.getAge());
        req.getServletContext().getRequestDispatcher("/student_form.jsp").forward(req, res);
    }

    @PostMapping(value = "/students/{id}")
    public void updateStudent(@PathVariable int id, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Student student = service.getStudent(id);
        student.setName(req.getParameter("name"));
        student.setAge(Integer.parseInt(req.getParameter("age")));
        service.saveStudent(student);
        res.sendRedirect("/students/students");
    }

    @GetMapping("/students/add")
    public void addStudent(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Student student = new Student("Enter student's name", 0);
        service.saveStudent(student);
        int id = student.getId();
        res.sendRedirect("/students/students/"+id);
    }

    @GetMapping("/students/delete/{id}")
    public void deleteStudent(@PathVariable int id, HttpServletRequest req, HttpServletResponse res) throws IOException {
        service.deleteStudent(id);

        res.sendRedirect("/students/students");

    }


}
