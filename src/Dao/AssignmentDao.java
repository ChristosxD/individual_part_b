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
import myindividualproject.Assignment;
import myindividualproject.Course;
import myindividualproject.Assignment;
import myindividualproject.Student;

public class AssignmentDao extends GenericDao {

    private static final String FINDBYID = "SELECT * FROM assignment WHERE id = ?";
    private static final String FINDALL = "SELECT * FROM assignment";
    private static final String CREATE = "INSERT INTO assignment (title, description, subDateTime, oralMark, totalMark) VALUES (?, ?, ?, ?, ?)";
    private static final String ASSIGNMENTPERCOURSE = "select * from assignment\n"
            + "join coursesperassignments on  assignment.id= coursesperassignments.assignment_id\n"
            + "join course on  course.id = coursesperassignments.course_id\n"
            + "where course.id = ? ";
    private static final String ASSIGNMENTPERSTUDENT = "select * from course\n"
            + "join coursesperstudents on course.id = coursesperstudents.course_id\n"
            + "join coursesperassignments on course.id = coursesperassignments.course_id\n"
            + "join student on student.id = coursesperstudents.student_id\n"
            + "join assignment on assignment.id = coursesperassignments.Assignment_ID\n"
            + "where student.id = ?;";
    private static final String INSERTASSIGNMENTTOACOURSE ="insert into coursesperassignments(Course_id,assignment_id)"
            + "values (?,?)";

    public Assignment findById(int id) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Assignment assignment = null;
        try {
            pstm = conn.prepareStatement(FINDBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int assignmentId = rs.getInt(1);
            String title = rs.getString(2);
            String description = rs.getString(3);
            Date subDateTime = rs.getDate(4);
            LocalDate subLocalDateTime = subDateTime.toLocalDate();
            int oralMark = rs.getInt(5);
            int totalMark = rs.getInt(6);
            assignment = new Assignment(assignmentId, title, description, subLocalDateTime, oralMark, totalMark);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(rs, pstm, conn);
        }
        return assignment;
    }

    public ArrayList<Assignment> getAllAssignments() {
        ArrayList<Assignment> allAssignments = new ArrayList();
        Connection conn = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int assignmentId = rs.getInt(1);
                String title = rs.getString(2);
                String description = rs.getString(3);
                Date subDateTime = rs.getDate(4);
                LocalDate subLocalDateTime = subDateTime.toLocalDate();
                int oralMark = rs.getInt(5);
                int totalMark = rs.getInt(6);
                Assignment assignment = new Assignment(assignmentId, title, description, subLocalDateTime, oralMark, totalMark);
                allAssignments.add(assignment);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(rs, stmt, conn);
        }
        return allAssignments;
    }

    public void saveAssignment(Assignment assignment) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(CREATE);
            pstm.setString(1, assignment.getTitle());
            pstm.setString(2, assignment.getDescription());
            pstm.setDate(3, Date.valueOf(assignment.getSubDateTime()));
            pstm.setInt(4, assignment.getOralMark());
            pstm.setInt(5, assignment.getTotalMark());
            int result = pstm.executeUpdate();
            if (result == 1) {
                System.out.println("Assignment successfully created!!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(pstm, conn);
        }
    }

    public ArrayList<Assignment> AssignmentPerCourse(Course course) {
        ArrayList<Assignment> allAssignmentPerCourse = new ArrayList();
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(ASSIGNMENTPERCOURSE);
            pstm.setInt(1, course.getCourseId());
            rs = pstm.executeQuery();
            while (rs.next()) {
                int assignmentId = rs.getInt("assignment.id");
                String title = rs.getString("assignment.title");
                String description = rs.getString("assignment.description");
                Date subDateTime = rs.getDate("assignment.subDateTime");
                LocalDate subLocalDateTime = subDateTime.toLocalDate();
                int oralMark = rs.getInt("assignment.oralMark");
                int totalMark = rs.getInt("assignment.totalMark");
                Assignment assignment = new Assignment(assignmentId, title, description, subLocalDateTime, oralMark, totalMark);
                course.addAssignmets(assignment);
                allAssignmentPerCourse.add(assignment);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(rs, pstm, conn);
        }
        return allAssignmentPerCourse;
    }

    public ArrayList<Assignment> AssignmentPerStudent(Student student) {
        CourseDao cdao = new CourseDao();
        ArrayList<Assignment> allAssignmenttPerStudent = new ArrayList();
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(ASSIGNMENTPERSTUDENT);
            pstm.setInt(1, student.getStudentId());
            rs = pstm.executeQuery();
            while (rs.next()) {
                int assignmentId = rs.getInt("assignment.id");
                String title = rs.getString("assignment.title");
                String description = rs.getString("assignment.description");
                Date subDateTime = rs.getDate("assignment.subDateTime");
                LocalDate subLocalDateTime = subDateTime.toLocalDate();
                int oralMark = rs.getInt("assignment.oralMark");
                int totalMark = rs.getInt("assignment.totalMark");
                int courseId = rs.getInt("course_id");
                Course course = cdao.findById(courseId);
                Assignment assignment = new Assignment(assignmentId, title, description, subLocalDateTime, oralMark, totalMark,course);
                allAssignmenttPerStudent.add(assignment);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(rs, pstm, conn);
        }
        return allAssignmenttPerStudent;
    }
        public void insertAssignmentToACourse(Course course,Assignment assignment) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(INSERTASSIGNMENTTOACOURSE);
            pstm.setInt(1, course.getCourseId());
            pstm.setInt(2, assignment.getAssignmentId());
            int result = pstm.executeUpdate();
            if (result == 1) {
                System.out.println("Assignment :" + assignment.getTitle() + ", added to Course : " + course.getTitle() +"\n" + course.getStream());
            }
        } catch (SQLException ex) {
            System.out.println("This One Assignment:\n" +assignment.getAssignmentId()+")"+assignment.getTitle() + " Already Exist On This Course: " +course.getCourseId() +")" +course.getTitle() +" " +course.getStream());
            System.out.println("");
        } finally {
            closeConnections(pstm, conn);
        }
    }

}
