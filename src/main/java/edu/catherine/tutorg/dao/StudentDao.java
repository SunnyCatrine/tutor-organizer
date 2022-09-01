package main.java.edu.catherine.tutorg.dao;

import main.java.edu.catherine.tutorg.model.client.Contact;
import main.java.edu.catherine.tutorg.model.client.Location;
import main.java.edu.catherine.tutorg.model.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.client.impl.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static main.java.edu.catherine.tutorg.util.sql.SqlConstants.*;
import static main.java.edu.catherine.tutorg.util.sql.SqlUtil.*;

public final class StudentDao {
    private static final StudentDao INSTANCE = new StudentDao();


    // DONE: 30.08.2022 all const should be in util constants class
    public Student create(Connection connection, Student studentRequest) throws SQLException {
        Integer studentId = null;
        // DONE: 30.08.2022 response and request are not same entities - they shouldn't be equal
        Student studentResponse = buildStudent(studentRequest);

        try (PreparedStatement studentCreate = connection.prepareStatement(CREATE_STUDENT_SQL, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement contactCreate = connection.prepareStatement(CREATE_CONTACT_SQL)) {

            studentCreate.setString(1, studentRequest.getFirstName());
            studentCreate.setString(2, studentRequest.getLastName());
            studentCreate.setString(3, StudentStatus.ACTIVE.getStatus());
            studentCreate.setInt(4, studentRequest.getDefaultLessonParam().getPrice());
            studentCreate.setInt(5, studentRequest.getDefaultLessonParam().getDuration());

            studentCreate.executeUpdate();
            ResultSet resultSet = studentCreate.getGeneratedKeys();
            if (resultSet.next()) {
                studentId = resultSet.getInt(ID);
                studentResponse.setClientId(studentId);
            }

            contactCreate.setString(1, studentRequest.getLocation().getCountry());
            contactCreate.setString(2, studentRequest.getLocation().getCity());
            contactCreate.setString(3, studentRequest.getContact().getPhoneNo());
            contactCreate.setString(4, studentRequest.getContact().getSkype());
            contactCreate.setString(5, studentRequest.getLocation().getTimezone());
            contactCreate.setInt(6, studentId);

            contactCreate.executeUpdate();

            return studentResponse;
        }
    }

    public List<Student> findAll(Connection connection) throws SQLException {
        List<Student> resultList = new ArrayList<>();
        try (PreparedStatement findAllStudents = connection.prepareStatement(FIND_ALL_SQL)) {
            findAllStudents.executeQuery();
            ResultSet resultSet = findAllStudents.getResultSet();
            while (resultSet.next()) {
                resultList.add(buildStudent(resultSet));
            }
            return resultList;
        }
    }



    // DONE: 30.08.2022 private methods should be in the end of the class
    public Student findBy(Connection connection, Integer studentId) throws SQLException {
        Student resultStudent = null;
        try (PreparedStatement findStudentById = connection.prepareStatement(FIND_BY_ID)) {

            findStudentById.setInt(1,studentId);

            findStudentById.executeQuery();
            ResultSet resultSet = findStudentById.getResultSet();
            if (resultSet.next()) {
                resultStudent = buildStudent(resultSet);
            }
            return resultStudent;
        }
    }

    public Student deleteBy(Connection connection, Integer studentId) throws SQLException {
        // DONE: 30.08.2022 you should notice all spaces in your code even after commas
        Student resultStudent = findBy(connection, studentId);
        try (PreparedStatement deleteStudentById = connection.prepareStatement(DELETE_STUDENT_BY_ID)) {
            deleteStudentById.setInt(1, studentId);
            if (deleteStudentById.executeUpdate()>0) {
                return resultStudent;
            }
            return null;
        }
    }

    public Student update(Connection connection, Integer id, Student studentRequest) throws SQLException {
        String updateStudentSql = getUpdateStudentSql(studentRequest);
        String updateContactSql = getUpdateContactSql(studentRequest);
        // TODO: 30.08.2022 spaces.. fix in all other methods too

        // DONE: 30.08.2022 name of condition is bad
        if (availableFieldForUpdate(updateStudentSql)) {
            // DONE: 30.08.2022 not camel case
            try (PreparedStatement updateStudentById = connection.prepareStatement(updateStudentSql)) {
                updateStudentById.setInt(1, id);
                updateStudentById.executeUpdate();
            }
        }
        if (! updateContactSql.isEmpty()) {
            try (PreparedStatement updateContactByStudentID = connection.prepareStatement(updateContactSql)) {
                updateContactByStudentID.setInt(1, id);
                updateContactByStudentID.executeUpdate();
            }
        }
        return findBy(connection, id);
    }

    public static StudentDao getInstance() {
        return INSTANCE;
    }

    private StudentDao() {
    }


    // DONE: 30.08.2022 methods like these are not dao methods - you should create util classes for them

    private Student buildStudent(ResultSet resultSet) throws SQLException {
        // DONE: 30.08.2022 no constants in code
        Contact contact = new Contact(resultSet.getString(PHONE_NO),
                resultSet.getString(SKYPE));
        Location location = new Location(resultSet.getString(COUNTRY),
                resultSet.getString(CITY));
        // TODO: 30.08.2022 you should notice all IDEA remarks
        return new Student(
                resultSet.getInt(ID),
                resultSet.getString(FIRST_NAME),
                resultSet.getString(LAST_NAME),
                contact,
                location,
                StudentStatus.valueOf(resultSet.getString(STATUS)));
    }

    private Student buildStudent (Student student) {
        return new Student(student.getFirstName(),
                student.getLastName(),
                student.getContact(),
                student.getLocation(),
                student.getDefaultLessonParam());
    }




//    public List<Student> findAllStudents(Connection connection) {
//        try(PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            List<Student> resultList = new ArrayList<>();
//            while (resultSet.next()) {
//                Student student = buildStudent(resultSet);
//                resultList.add(student);
////                System.out.println(student);
//            }
//            return resultList;
//        } catch (SQLException e) {
//            throw new DaoException(e);
//        }
//    }
//
//    private Student buildStudent(ResultSet resultSet) throws SQLException {
//        return new Student(
//                resultSet.getInt("id"),
//                resultSet.getString("first_name"),
//                resultSet.getString("last_name"),
//                StudentStatus.valueOf(resultSet.getString("status")));
//    }
//
//    public Student createStudent(Student studentRequest, Connection connection) throws SQLException {
//        Student studentResponse = studentRequest;
//        try(PreparedStatement preparedStatement = connection.prepareStatement(CREATE_STUDENT_SQL, Statement.RETURN_GENERATED_KEYS)) {
//
//            preparedStatement.setString(1, studentRequest.getFirstName());
//            preparedStatement.setString(2,studentRequest.getLastName());
//            preparedStatement.setString(3,studentRequest.getStudentStatus().getStatus());
//            preparedStatement.executeUpdate();
//
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            if (resultSet.next()) {
//                studentResponse.setClientId(resultSet.getInt("id"));
//            }
//            return  studentResponse;
//        } catch (Exception e) {
//            throw e;
//        }

//    }

}
