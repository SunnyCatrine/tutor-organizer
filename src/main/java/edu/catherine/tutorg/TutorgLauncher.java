package main.java.edu.catherine.tutorg;

import main.java.edu.catherine.tutorg.controller.AgentController;
import main.java.edu.catherine.tutorg.controller.StudentController;
import main.java.edu.catherine.tutorg.controller.StudentsAgentsController;
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
        StudentsAgentsController studentsAgentsController = StudentsAgentsController.getINSTANCE();

        checkStudentAgentController(studentsAgentsController);
        checkAgentController(agentController);
    }

    private static void checkStudentAgentController(StudentsAgentsController studentsAgentsController) throws SQLException {
        System.out.println("ASSIGN AGENT 3 TO STUDENT 1");
        System.out.println(studentsAgentsController.assignAgentToStudent("1", "3"));
    }

    private static void checkAgentController(AgentController agentController) throws SQLException {
        System.out.println("ADD NEW AGENT to student_id 1");
        AgentRequest agentRequest = AgentRequest.builder()
                .firstName("Eny")
                .lastName("Skywolker")
                .phoneNo("111111111")
                .country("NOname")
                .city("unknown")
                .timezone("absent")
                .studentId("1")
                .build();

        AgentResponse addedAgent = agentController.create(agentRequest);
        System.out.println(addedAgent);
        System.out.println();

        System.out.println("FIND AGENTs by student id 1");
        List<AgentResponse> foundAgents = agentController.findByStudentId("1");
        System.out.println(foundAgents);

//        System.out.println("DELETE AGENT by id 5");
//        AgentResponse deletedAgent = agentController.deleteById("5");
//        System.out.println(deletedAgent);
    }

    private void checkStudentController(StudentController studentController) throws SQLException {
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