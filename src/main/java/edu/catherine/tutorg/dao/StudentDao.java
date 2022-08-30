package main.java.edu.catherine.tutorg.dao;

import main.java.edu.catherine.tutorg.exception.DaoException;
import main.java.edu.catherine.tutorg.model.client.StudentStatus;
import main.java.edu.catherine.tutorg.model.client.ext.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class StudentDao {
    private static final StudentDao INSTANCE = new StudentDao();

    private static final String CREATE_STUDENT_SQL = "INSERT INTO student (first_name, last_name, status, default_lesson_price, default_lesson_duration_minutes) VALUES (?,?,?,?,?)";
    private static final String CREATE_CONTACT_SQL = "INSERT INTO student_contact_info (country, city, phone_no, skype, timezone, student_id) VALUES (?,?,?,?,?,?)";

    private static final String FIND_ALL_SQL = "SELECT student.id, student.first_name, student.last_name, student.status FROM student";

    private StudentDao() {
    }

    public static StudentDao getInstance() {
        return INSTANCE;
    }

    public Student create(Connection connection, Student studentRequest) throws SQLException {
        Integer studentId = null;
        Student studentResponse = studentRequest;

        try (PreparedStatement studentCreate = connection.prepareStatement(CREATE_STUDENT_SQL, Statement.RETURN_GENERATED_KEYS);
        PreparedStatement contactCreate = connection.prepareStatement(CREATE_CONTACT_SQL)) {

            studentCreate.setString(1,studentRequest.getFirstName());
            studentCreate.setString(2,studentRequest.getLastName());
            studentCreate.setString(3,StudentStatus.ACTIVE.getStatus());
            studentCreate.setInt(4, studentRequest.getDefaultLessonParam().getPrice());
            studentCreate.setInt(5, studentRequest.getDefaultLessonParam().getDuration());

            studentCreate.executeUpdate();
            ResultSet resultSet = studentCreate.getGeneratedKeys();
            if (resultSet.next()) {
                studentId = resultSet.getInt("id");
                studentResponse.setClientId(studentId);
            }

            contactCreate.setString(1,studentRequest.getLocation().getCountry());
            contactCreate.setString(2,studentRequest.getLocation().getCity());
            contactCreate.setString(3,studentRequest.getContact().getPhoneNo());
            contactCreate.setString(4,studentRequest.getContact().getSkype());
            contactCreate.setString(5,studentRequest.getLocation().getTimezone());
            contactCreate.setInt(6,studentId);

            contactCreate.executeUpdate();

            return studentResponse;
        }
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
