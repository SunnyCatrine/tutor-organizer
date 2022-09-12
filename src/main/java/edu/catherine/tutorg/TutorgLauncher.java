package main.java.edu.catherine.tutorg;

import main.java.edu.catherine.tutorg.controller.StudentController;
import main.java.edu.catherine.tutorg.model.dto.StudentRequest;
import main.java.edu.catherine.tutorg.model.dto.StudentResponse;

import java.sql.SQLException;
import java.util.List;

public class TutorgLauncher {

    // TODO: 11.09.2022 сделать коммит, проверить методы агента, добавить update

    public static void main(String[] args) throws SQLException {
        StudentController studentController = StudentController.getINSTANCE();

        System.out.println("ALL STUDENTS");
        List<StudentResponse> students = studentController.findAll();
        students.forEach(System.out::println);
        System.out.println();

        System.out.println("ADD NEW STUDENT");
        StudentRequest studentRequestBuilt = StudentRequest.builder()
                .firstName("Hero")
                .lastName("Nakamuro")
                .phoneNo("14434145")
                .skype("superHero")
                .country("Japan")
                .city("Keko")
                .defaultPrice("111")
                .defaultDuration("2222")
                .timezone("+9")
                .status("ACTIVE")
                .build();

        StudentRequest studentRequest = new StudentRequest(
                "Tracy",
                "Straus",
                "333333",
                "TS",
                "Germany",
                "Berlin",
                "-2",
                "15000",
                "100",
                "ACTIVE");
        StudentResponse addedStudent = studentController.create(studentRequestBuilt);
        System.out.println(addedStudent);
        System.out.println();

        System.out.println("ALL STUDENTS again");

        students = studentController.findAll();
        students.forEach(System.out::println);

        System.out.println();

        System.out.println("findStudent id 4");
        StudentResponse findStudent = studentController.findBy(4);
        System.out.println(findStudent);

        System.out.println();

        System.out.println("Delete student id 13");
        StudentResponse deletedStudent = studentController.deleteBy(13);
        System.out.println(deletedStudent);

        System.out.println();

        System.out.println("ALL STUDENTS Again");

        students = studentController.findAll();
        students.forEach(System.out::println);
        System.out.println();



        System.out.println("Update student id 16");
        StudentRequest updateStudentRequest = new StudentRequest(
                "Rene",
                null,
                null,
                "Renenene",
                null,
                null,
                null,
                null,
                null,
                "ARCHIVED"
        );

        StudentResponse updatedStudent = studentController.update(16, updateStudentRequest);
        System.out.println(updatedStudent);
        System.out.println();

        System.out.println("ALL STUDENTS Again");

        students = studentController.findAll();
        students.forEach(System.out::println);

    }
}