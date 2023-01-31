import dao.StudentDAOImpl;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tasks {


    public static void main(String[] args) {
        StudentDAOImpl s = new StudentDAOImpl();
        //Здесь создаем 1000 студентов
//        for (int i = 0; i < 1000; i++){
//            s.saveStudent(new Student("Student "+i, new Random().nextInt(3)+3));
//        }


        //Провеяем кто под номером 3
        System.out.println(s.getStudent(3));

        //Удаляем студента с id=3
        s.deleteStudent(3);

        //Проверяем, что такой студент удален, выводим кусочек
        List<Student> arr = s.getAllStudents();
        for (int i = 0; i < 10; i++) {
            System.out.println(arr.get(i));
        }

        //P.S: Да, я понимаю, что если нужно добавить кучу студентов, нужно написат отдельный
        //метод, который будет принимать лист студентов и одной транзакцией их коммитить.
        //Использован метод добавления по одному в цикле исключитело для проверки работоспособности
        //метода, требуемого в задании.

    }
}
