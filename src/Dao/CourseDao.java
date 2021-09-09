package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import myindividualproject.Course;
import myindividualproject.Course;

public class CourseDao extends GenericDao {

    private static final String FINDBYID = "SELECT * FROM course WHERE id = ?";
    private static final String FINDALL = "SELECT * FROM course";
    private static final String CREATE = "INSERT INTO course (title, stream, type, startDate, endDate) VALUES (?, ?, ?, ?, ?)";

    public Course findById(int id) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Course course = null;
        try {
            pstm = conn.prepareStatement(FINDBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int courseId = rs.getInt(1);
            String title = rs.getString(2);
            String stream = rs.getString(3);
            String type = rs.getString(4);
            Date startDate = rs.getDate(5);
            LocalDate startLocalDate = startDate.toLocalDate();
            Date endDate = rs.getDate(6);
            LocalDate endLocalDate = endDate.toLocalDate();
            course = new Course(courseId, title, stream, type, startLocalDate, endLocalDate);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(rs, pstm, conn);
        }
        return course;
    }

    public ArrayList<Course> getAllCourses() {
        ArrayList<Course> allCourses = new ArrayList();
        Connection conn = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int courseId = rs.getInt(1);
                String title = rs.getString(2);
                String stream = rs.getString(3);
                String type = rs.getString(4);
                Date startDate = rs.getDate(5);
                LocalDate startLocalDate = startDate.toLocalDate();
                Date endDate = rs.getDate(6);
                LocalDate endLocalDate = endDate.toLocalDate();
                Course course = new Course(courseId, title, stream, type, startLocalDate, endLocalDate);
                allCourses.add(course);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(rs, stmt, conn);
        }
        return allCourses;
    }

    public void saveCourse(Course course) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(CREATE);
            pstm.setString(1, course.getTitle());
            pstm.setString(2, course.getStream());
            pstm.setString(3, course.getType());
            pstm.setDate(4, Date.valueOf(course.getStartDate()));
            pstm.setDate(5, Date.valueOf(course.getStartDate()));
            int result = pstm.executeUpdate();
            if (result == 1) {
                System.out.println("Course successfully created!!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(pstm, conn);
        }
    }

}
