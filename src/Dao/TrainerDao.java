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
import myindividualproject.Trainer;
import myindividualproject.Trainer;

public class TrainerDao extends GenericDao {

    private static final String FINDBYID = "SELECT * FROM trainer WHERE id = ?";
    private static final String FINDALL = "SELECT * FROM trainer";
    private static final String CREATE = "INSERT INTO trainer (firstName, lastName, subject) VALUES (?, ?, ?)";
    private static final String TRAINERPERCOURSE = "select * from trainer\n"
            + "join CoursesPerTrainers on  trainer.id= CoursesPerTrainers.trainer_id\n"
            + "join course on  course.id = CoursesPerTrainers.course_id\n"
            + "where course.id = ? ";
    private static final String INSERTTRAINERTOACOURSE ="insert into coursespertrainers(Course_id,trainer_id)"
            + "values (?,?)";

    public Trainer findById(int id) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Trainer trainer = null;
        try {
            pstm = conn.prepareStatement(FINDBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int trainerId = rs.getInt(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            String subject = rs.getString(4);
            trainer = new Trainer(trainerId, firstName, lastName, subject);
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(rs, pstm, conn);
        }
        return trainer;
    }

    public ArrayList<Trainer> getAllTrainers() {
        ArrayList<Trainer> allTrainers = new ArrayList();
        Connection conn = getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int trainerId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String subject = rs.getString(4);
                Trainer trainer = new Trainer(trainerId, firstName, lastName, subject);
                allTrainers.add(trainer);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(rs, stmt, conn);
        }
        return allTrainers;
    }

    public void saveTrainer(Trainer trainer) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(CREATE);
            pstm.setString(1, trainer.getFirstName());
            pstm.setString(2, trainer.getLastName());
            pstm.setString(3, trainer.getSubject());
            int result = pstm.executeUpdate();
            if (result == 1) {
                System.out.println("Trainer successfully created!!");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(pstm, conn);
        }
    }

    public ArrayList<Trainer> TrainerPerCourse(Course course) {
        ArrayList<Trainer> allTrainerPerCourse = new ArrayList();
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(TRAINERPERCOURSE);
            pstm.setInt(1, course.getCourseId());
            rs = pstm.executeQuery();
            while (rs.next()) {
                int trainerId = rs.getInt("trainer.id");
                String firstName = rs.getString("trainer.FirstName");
                String lastName = rs.getString("trainer.lastname");
                String subject = rs.getString("subject");
                Trainer trainer = new Trainer(trainerId, firstName, lastName, subject);
                course.addTrainers(trainer);
                allTrainerPerCourse.add(trainer);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            closeConnections(rs, pstm, conn);
        }
        return allTrainerPerCourse;
    }
        public void insertTrainerToACourse(Trainer trainer,Course course) {
        Connection conn = getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(INSERTTRAINERTOACOURSE);
            pstm.setInt(1, course.getCourseId());
            pstm.setInt(2, trainer.getTrainerId());
            int result = pstm.executeUpdate();
            if (result == 1) {
                System.out.println("Trainer :" + trainer.getFirstName() + "" + trainer.getLastName()+ ", added to Course : " + course.getTitle() +"\n" + course.getStream());
            }
        } catch (SQLException ex) {
            System.out.println("This One Trainer :\n" +trainer.getTrainerId()+")"+trainer.getFirstName() +" "+ trainer.getLastName() + " Already Exist On This Course: " +course.getCourseId() +")" +course.getTitle() +" " +course.getStream());
            System.out.println("");
        } finally {
            closeConnections(pstm, conn);
        }
    }
}
