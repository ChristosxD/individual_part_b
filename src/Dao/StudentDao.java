package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import myindividualproject.Course;
import myindividualproject.Student;

public class StudentDao extends GenericDao {

    private static final String FINDBYID = "SELECT * FROM student WHERE id = ?";
    private static final String FINDALL = "SELECT * FROM student";
    private static final String CREATE = "INSERT INTO student (firstname, lastname, dateOfBirth, tuitionFees) VALUES (?, ?, ?, ?)";
    private static final String STUDENTPERCOURSE = "select * from student\n"
            + "join CoursesPerStudents on  student.id= CoursesPerStudents.student_id\n"
            + "join course on  course.id = CoursesPerStudents.course_id\n"
            + "where course.id = ? ";
    private static final String STUDENTBELONGMORECOURSES = "select * from student\n"
            + "join coursesperstudents on  student.id= coursesperstudents.student_id\n"
            + "join course on  course.id = coursesperstudents.course_id\n"
            + "where student.id = ?";
    private static final String INSERTSTUDENTTOACOURSE ="insert into coursesperstudents(Course_id,student_id)"
            + "values (?,?)";
    

    public Student findById(int id) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Student student = null;
        try {
            pstm = conn.prepareStatement(FINDBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int studentId = rs.getInt(1);
            String firstname = rs.getString(2);
            String lastname = rs.getString(3);
            Date dateOfBirth = rs.getDate(4);
            LocalDate localDateOfBirth = dateOfBirth.toLocalDate();
            int tuitionFees = rs.getInt(5);
            student = new Student(studentId, firstname, lastname, localDateOfBirth, tuitionFees);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(rs, pstm, conn);
        }
        return student;
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> allStudents = new ArrayList();
        Connection conn = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int studentId = rs.getInt(1);
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                Date dateOfBirth = rs.getDate(4);
                LocalDate localDateOfBirth = dateOfBirth.toLocalDate();
                int tuitionFees = rs.getInt(5);
                Student student = new Student(studentId, firstname, lastname, localDateOfBirth, tuitionFees);
                allStudents.add(student);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(rs, stmt, conn);
        }
        return allStudents;
    }

    public void saveStudent(Student student) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(CREATE);
            pstm.setString(1, student.getFirstName());
            pstm.setString(2, student.getLastName());
            pstm.setDate(3, Date.valueOf(student.getDateOfBday()));
            pstm.setInt(4, student.getTuitionFees());
            int result = pstm.executeUpdate();
            if (result == 1) {
                System.out.println("Student successfully created!!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(pstm, conn);
        }
    }

    public ArrayList<Student> StudentPerCourse(Course course) {
        ArrayList<Student> allStudentPerCourse = new ArrayList();
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(STUDENTPERCOURSE);
            pstm.setInt(1, course.getCourseId());
            rs = pstm.executeQuery();
            while (rs.next()) {
                int studentId = rs.getInt("student.id");
                String firstName = rs.getString("student.FirstName");
                String lastName = rs.getString("student.lastname");
                Date dateOfBirth = rs.getDate("dateOfBirth");
                LocalDate LocalDateOfBirth = dateOfBirth.toLocalDate();
                int tuitionFees = rs.getInt("tuitionFees");
                Student student = new Student(studentId, firstName, lastName, LocalDateOfBirth, tuitionFees);
                course.addStudent(student);
                allStudentPerCourse.add(student);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(rs, pstm, conn);
        }
        return allStudentPerCourse;
    }

    public ArrayList<Course> CoursePerStudent(Student student) {
        ArrayList<Course> allStudentWithMoreCourses = new ArrayList();
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(STUDENTBELONGMORECOURSES);
            pstm.setInt(1, student.getStudentId());
            rs = pstm.executeQuery();
            while (rs.next()) {
                int courseId = rs.getInt("Id");
                String title = rs.getString("title");
                String stream = rs.getString("stream");
                String type = rs.getString("type");
                Date startDate = rs.getDate("startDate");
                LocalDate startLocalDate = startDate.toLocalDate();
                Date endDate = rs.getDate("endDate");
                LocalDate endLocalDate = endDate.toLocalDate();
                Course course = new Course(courseId, title, stream, type, startLocalDate, endLocalDate);
                allStudentWithMoreCourses.add(course);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(rs, pstm, conn);
        }
        return allStudentWithMoreCourses;
    }
    
    
    public void insertStudentToACourse(Student student,Course course) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(INSERTSTUDENTTOACOURSE);
            pstm.setInt(1, course.getCourseId());
            pstm.setInt(2, student.getStudentId());
            int result = pstm.executeUpdate();
            if (result == 1) {
                System.out.println("Student :" + student.getFirstName() + "" +student.getLastName()+ ", added to Course : " + course.getTitle() +"\n" + course.getStream());
            }
        } catch (SQLException ex) {
            System.out.println("This One Student:\n" +student.getStudentId()+")"+student.getFirstName() +" "+ student.getLastName() + " Already Exist On This Course: " +course.getCourseId() +")" +course.getTitle() +" " +course.getStream());
            System.out.println("");
        } finally {
            closeConnections(pstm, conn);
        }
    }
}
