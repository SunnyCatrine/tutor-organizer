package main.java.edu.catherine.tutorg;

import main.java.edu.catherine.tutorg.controller.StudentController;
import main.java.edu.catherine.tutorg.model.dto.StudentRequest;
import main.java.edu.catherine.tutorg.model.dto.StudentResponse;

import java.sql.SQLException;
import java.util.List;

public class TutorgLauncher {

    public static void main(String[] args) throws SQLException {
        StudentController studentController = StudentController.getINSTANCE();

        System.out.println("ALL STUDENTS");
        List<StudentResponse> students = studentController.findAll();
        students.forEach(System.out::println);
        System.out.println();

        System.out.println("ADD NEW STUDENT");
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
        StudentResponse addedStudent = studentController.create(studentRequest);
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

        System.out.println("Delete student id 6");
        StudentResponse deletedStudent = studentController.deleteBy(6);
        System.out.println(deletedStudent);

        System.out.println();

        System.out.println("ALL STUDENTS Again");

        students = studentController.findAll();
        students.forEach(System.out::println);
        System.out.println();



//        System.out.println("Update student id 5");
//        StudentRequest updateStudentRequest = new StudentRequest(
//                "Rene",
//                null,
//                null,
//                "Renenene",
//                null,
//                null,
//                null,
//                null,
//                null,
//                "ARCHIVED"
//        );
//
//        StudentResponse updatedStudent = studentController.update(31, updateStudentRequest);
//        System.out.println(updatedStudent);
//        System.out.println();
//
//        System.out.println("ALL STUDENTS Again");
//
//        students = studentController.findAll();
//        students.forEach(System.out::println);





//        CreateStudentRequestDto studentDto = new CreateStudentRequestDto(
//                "Vasiliy",
//                "Terkin",
//                "+79091234567",
//                "VasyaTerkin",
//                "Russia",
//                "Moscow",
//                "GMT +3",
//                "MATH5",
//                null,
//                null,
//                "1000",
//                "60",
//                "MONDAY",
//                null,
//                null,
//                null,
//                "12:00",
//                null,
//                null,
//                null,
//                "2022-09-23",
//                "2023-05-31");
//
//
//        CreateStudentResponseDto createStudentResponseDto = studentController.createStudent(studentDto);
//        System.out.println(createStudentResponseDto);
//
//        List<FindStudentResponseDto> findStudents = studentController.findAllStudents();
//        for (FindStudentResponseDto findStudent: findStudents) {
//            System.out.println(findStudent);
//        }
    }
}