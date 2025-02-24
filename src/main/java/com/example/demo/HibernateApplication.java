package com.example.demo;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
        };
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
