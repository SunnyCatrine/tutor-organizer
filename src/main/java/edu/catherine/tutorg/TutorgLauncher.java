package main.java.edu.catherine.tutorg;

import main.java.edu.catherine.tutorg.controller.AgentController;
import main.java.edu.catherine.tutorg.controller.StudentController;
import main.java.edu.catherine.tutorg.model.dto.AgentRequest;
import main.java.edu.catherine.tutorg.model.dto.AgentResponse;
import main.java.edu.catherine.tutorg.model.dto.StudentRequest;
import main.java.edu.catherine.tutorg.model.dto.StudentResponse;

import java.sql.SQLException;
import java.util.List;

public class TutorgLauncher {

    public static void main(String[] args) throws SQLException {
        StudentController studentController = StudentController.getINSTANCE();
        AgentController agentController = AgentController.getInstance();

//        checkAgentController(agentController);
        checkStudentController(studentController);

    }


    private static void checkAgentController(AgentController agentController) throws SQLException {
        System.out.println("ADD NEW AGENT to student_id 3");
        AgentRequest agentRequest = AgentRequest.builder()
                .firstName("Mur")
                .lastName("Anamur")
                .phoneNo("0000000")
                .country("USA")
                .city("LA")
                .timezone("789")
                .studentId("3")
                .build();

        AgentResponse addedAgent = agentController.create(agentRequest);
        System.out.println(addedAgent);
        System.out.println();

        System.out.println("FIND AGENTs by student id 3");
        List<AgentResponse> foundAgents = agentController.findByStudentId("3");
        System.out.println(foundAgents);

        System.out.println("DELETE AGENT by id 4");
        AgentResponse deletedAgent = agentController.deleteById("4");
        System.out.println(deletedAgent);
    }

    private static void checkStudentController(StudentController studentController) throws SQLException {
        System.out.println("ASSIGN agent 1 to student 5");
        System.out.println(studentController.assignAgent("5", "1"));


//        System.out.println("ALL STUDENTS");
//        List<StudentResponse> students = studentController.findAll();
//        students.forEach(System.out::println);
//        System.out.println();
//
//        System.out.println("ADD NEW STUDENT");
//        StudentRequest studentRequestBuilt = StudentRequest.builder()
//                .firstName("NoHero")
//                .lastName("Nakamuro")
//                .phoneNo("14434145")
//                .skype("superHero")
//                .country("Japan")
//                .city("Keko")
//                .defaultPrice("111")
//                .defaultDurationInMinutes("2222")
//                .timezone("+9")
//                .studentStatus("ACTIVE")
//                .build();
//
//
//        StudentResponse addedStudent = studentController.create(studentRequestBuilt);
//        System.out.println(addedStudent);
//        System.out.println();
//
//        System.out.println("ALL STUDENTS again");
//
//        students = studentController.findAll();
//        students.forEach(System.out::println);
//
//        System.out.println();
////
//        System.out.println("findStudent id 3");
//        StudentResponse findStudent = studentController.findBy(3);
//        System.out.println(findStudent);
//
//        System.out.println();
//
//        System.out.println("Delete student id 4");
//        StudentResponse deletedStudent = studentController.deleteBy(4);
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
//        System.out.println("Update student id 3");
//        StudentRequest updateStudentRequest = StudentRequest.builder()
//                .firstName("Joy")
//                .skype("Pirojoy")
//                .studentStatus("ARCHIVED")
//                .build();
//
//        StudentResponse updatedStudent = studentController.update(3, updateStudentRequest);
//        System.out.println(updatedStudent);
//        System.out.println();
//
//        System.out.println("ALL STUDENTS Again");
//
//        students = studentController.findAll();
//        students.forEach(System.out::println);
    }
}