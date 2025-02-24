package com.example.demo;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
//            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);
//            updateStudent(studentDAO);
//            removeStudent(studentDAO);
//            deleteAllStudents(studentDAO);

        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numRowDeleted = studentDAO.deleteAll();
        System.out.println("Number of rows deleted: " + numRowDeleted);
    }

    private void removeStudent(StudentDAO studentDAO) {
        int studentId = 3;

        System.out.println("Deleting student: " + studentId);

        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        //retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student id : " + studentId);
        Student student = studentDAO.findById(studentId);

        //change first name to "Scooby"
        System.out.println("Updating Student...");
        student.setFirstName("vryheid");
        studentDAO.update(student);

        //update the student
        studentDAO.update(student);

        //display the updated student
        System.out.println("Updated student: " + student);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("duck");

        for (Student student : students) {
            System.out.println("ByLastname " + student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        //get a list of students
        List<Student> students = studentDAO.findAll();
        //display the list of students
        for (Student student : students) {
            System.out.println("Find All Students : " + student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        //create the student object
        System.out.println("Creating new student...");
        Student student = new Student("daffy", "duck", "DDB@gmail.com");

        //save the student object
        System.out.println("Saving student...");
        studentDAO.save(student);

        //display id of the saved student
        int theId = student.getId();
        System.out.println("Saved Student Id " + theId);

        //retrieve based on the id : primary key
        System.out.println("Retrieving student with id " + theId);
        Student tempStudent = studentDAO.findById(theId);

        //display student
        System.out.println("Found the student: " + tempStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new student...");
        Student student1 = new Student("Vryheidfr", "Laquiel", "veeL@gmail.com");
        Student student2 = new Student("Vryheidfrdd", "Laquieldd", "veeLff@gmail.com");
        Student student3 = new Student("Vryheidfrvv", "Laquielvv", "veeLbb@gmail.com");

        //save the student object
        System.out.println("Saving student...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
    }

    private void createStudent(StudentDAO studentDAO) {

        //create the student object
        System.out.println("Creating new student...");
        Student student = new Student("Vryheid", "Laquiel", "vL@gmail.com");

        //save the student object
        System.out.println("Saving student...");
        studentDAO.save(student);

        //display id of the saved student
        System.out.println("Saved Student Id " + student.getId());


    }
}
