package main.java.edu.catherine.tutorg;

import main.java.edu.catherine.tutorg.controller.StudentController;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentRequest;
import main.java.edu.catherine.tutorg.model.dto.CreateStudentResponse;
import main.java.edu.catherine.tutorg.model.dto.FindStudentResponse;

import java.sql.SQLException;
import java.util.List;

public class TutorgLauncher {

    public static void main(String[] args) throws SQLException {
        StudentController studentController = StudentController.getINSTANCE();

        System.out.println("ALL STUDENTS");
        List<FindStudentResponse> students = studentController.findAll();
        students.forEach(System.out::println);
        System.out.println();

        System.out.println("ADD NEW STUDENT");
        CreateStudentRequest createStudentRequest = new CreateStudentRequest(
                "Sayler",
                "Sayler",
                "0000000",
                "Sayler",
                "Australia",
                "Sidney",
                "+6",
                "2000",
                "120",
                null);
        CreateStudentResponse addedStudent = studentController.create(createStudentRequest);
        System.out.println(addedStudent);
        System.out.println();

        System.out.println("ALL STUDENTS");

        students = studentController.findAll();
        students.forEach(System.out::println);

        System.out.println();

        System.out.println("findStudent id 10");
        FindStudentResponse findStudent = studentController.findBy(10);
        System.out.println(findStudent);

        System.out.println();
//
//        System.out.println("Delete student id 5");
//        Student deletedStudent = studentController.deleteBy(5);
//        System.out.println(deletedStudent);
//
//        System.out.println();
//
//        System.out.println("ALL STUDENTS Again");
//
//        students = studentController.findAll();
//        students.forEach(System.out::println);
//        System.out.println();
//
//
//
//        System.out.println("Update student id 6");
//        contact.setPhoneNo("+79780123456");
//        student.setFirstName("Angela");
//        student.setLastName(null);
//        student.setContact(contact);
//        student.setStudentStatus(StudentStatus.ARCHIVED);
//
//        Student updatedStudent = studentController.update(6, student);
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