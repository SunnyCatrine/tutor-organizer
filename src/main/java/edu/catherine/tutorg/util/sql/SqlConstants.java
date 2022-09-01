package main.java.edu.catherine.tutorg.util.sql;

public class SqlConstants {
    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String STATUS = "status";
    public static final String DEFAULT_LESSON_PRICE = "default_lesson_price";
    public static final String DEFAULT_LESSON_DURATION_MINUTES = "default_lesson_duration_minutes";
    public static final String COUNTRY = "country";
    public static final String CITY = "city";
    public static final String PHONE_NO = "phone_no";
    public static final String SKYPE = "skype";
    public static final String TIMEZONE = "timezone";

    public static final String SPACE = " ";
    public static final String EQUALS = "=";
    public static final String COMMA = ",";
    public static final String QUOTE = "'";

    public static final String UPDATE_STUDENT_SQL_START = "UPDATE student SET ";
    public static final String UPDATE_CONTACT_SQL_START = "UPDATE student_contact_info SET ";
    public static final String SQL_WHERE_ID = " WHERE id = ?";

    public static final String CREATE_STUDENT_SQL = "INSERT INTO student (first_name, last_name, status, default_lesson_price, default_lesson_duration_minutes) VALUES (?,?,?,?,?)";
    public static final String CREATE_CONTACT_SQL = "INSERT INTO student_contact_info (country, city, phone_no, skype, timezone, student_id) VALUES (?,?,?,?,?,?)";
    public static final String FIND_ALL_SQL = "SELECT student.id as id, student.first_name as first_name, student.last_name as last_name, student.status as status, student_contact_info.phone_no as phone_no, student_contact_info.skype as skype, student_contact_info.country as country, student_contact_info.city as city FROM student JOIN student_contact_info ON student.id = student_contact_info.student_id";
    public static final String FIND_BY_ID = FIND_ALL_SQL + " WHERE student.id = ?";
    public static final String DELETE_STUDENT_BY_ID = "DELETE FROM student WHERE id = ?" ;
}