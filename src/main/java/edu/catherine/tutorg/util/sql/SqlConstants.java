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
    public static final String AGENT_ID = "agent_id";

    public static final String STUDENT_ID = "student_id";
    public static final String STUDENT_FIRST_NAME = "student_first_name";
    public static final String STUDENT_LAST_NAME = "student_last_name";
    public static final String STUDENT_STATUS = "student_status";

    static final String SPACE = " ";
    static final String EQUALS = "=";
    static final String COMMA = ",";
    static final String QUOTE = "'";

    static final String UPDATE_STUDENT_SQL_START = "UPDATE student SET ";
    static final String UPDATE_CONTACT_SQL_START = "UPDATE student_contact_info SET ";
    static final String SQL_WHERE_ID = " WHERE id = ?";
    static final String SQL_WHERE_STUDENT_ID = " WHERE student_id = ?";
    private static final String SQL_WHERE_AGENT_ID = " WHERE agent.id = ?";

    public static final String CREATE_STUDENT_SQL = "INSERT INTO student (first_name, last_name, status, default_lesson_price, default_lesson_duration_minutes) VALUES (?,?,?,?,?)";
    public static final String CREATE_STUDENT_CONTACT_SQL = "INSERT INTO student_contact_info (country, city, phone_no, skype, timezone, student_id) VALUES (?,?,?,?,?,?)";
    public static final String FIND_ALL_STUDENTS_SQL = "SELECT student.id as id, student.first_name as first_name, student.last_name as last_name, student.status as status, student.default_lesson_price as default_lesson_price, student.default_lesson_duration_minutes as default_lesson_duration_minutes, student_contact_info.phone_no as phone_no, student_contact_info.skype as skype, student_contact_info.country as country, student_contact_info.city as city, student_contact_info.timezone as timezone FROM student JOIN student_contact_info ON student.id = student_contact_info.student_id";
    public static final String FIND_STUDENT_BY_ID = FIND_ALL_STUDENTS_SQL + " WHERE student.id = ?";
    public static final String DELETE_STUDENT_BY_ID = "DELETE FROM student" + SQL_WHERE_ID;

    public static final String CREATE_AGENT_SQL = "INSERT INTO agent (first_name, last_name, country, city, phone_no, timezone) VALUES (?,?,?,?,?,?)";
    public static final String ADD_NOTE_TO_STUDENTS_AGENTS_TABLE_SQL = "INSERT INTO students_agents (student_id, agent_id) VALUES (?,?)";
    public static final String FIND_AGENT_SQL = "SELECT agent.id as id, agent.first_name as first_name, agent.last_name as last_name, agent.country as country, agent.city as city, agent.timezone as timezone, agent.phone_no as phone_no, student.id as student_id, student.first_name as student_first_name, student.last_name as student_last_name, student.status as student_status FROM agent JOIN students_agents sa on agent.id = sa.agent_id JOIN student on sa.student_id = student.id" + SQL_WHERE_AGENT_ID;
    public static final String DELETE_AGENT_SQL = "DELETE FROM agent" + SQL_WHERE_ID;

    public static final String FIND_AGENT_ID_LIST_BY_STUDENT_ID = "SELECT agent_id FROM students_agents" + SQL_WHERE_STUDENT_ID;
    public static final String FIND_STUDENT_ID_LIST_BY_AGENT_ID = "SELECT student_id FROM students_agents WHERE agent_id = ?";
}
