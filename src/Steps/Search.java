package Steps;

import Dao.AssignmentDao;
import Dao.StudentDao;
import Dao.TrainerDao;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import myindividualproject.Assignment;
import myindividualproject.Course;
import myindividualproject.Student;
import myindividualproject.Trainer;

public class Search {

    /**
     * All print Methods();
     */

    public static void printAllStudents() {
        for (Student student : Student.getAllStudets()) {
            System.out.println(student.getStudentId()+")" + student.getFirstName() + " " + student.getLastName());
            System.out.println("");
        }
    }

    public static void printAllTrainers() {
        for (Trainer trainer : Trainer.getAllTrainers()) {
            System.out.println(trainer.getTrainerId()+")" + trainer.getFirstName() + "  " + trainer.getLastName());
            System.out.println("");
        }

    }

    public static void printAllAssignments() {
        for (Assignment assignment : Assignment.getAssign()) {
            System.out.println(assignment.getAssignmentId()+")" + assignment.getTitle());
            System.out.println("");
        }
    }

    public static void printAllCourses() {
        for (Course course : Course.getAllCourses()) {
            System.out.println(course.getCourseId()+")" + course.getTitle() + " " + course.getStream());
            System.out.println("");
        }
    }

    public static void printAllStudentsPerCourse() {
        StudentDao sdao = new StudentDao();
        for (Course course : Course.getAllCourses()) {
            System.out.println("" + course.getCourseId() + ")" + course.getTitle() + "\n  " + course.getStream());
            for (Student student : sdao.StudentPerCourse(course)) {
                System.out.println("        *" + student.getFirstName() + " " + student.getLastName());
            }
        }
    }

    public static void printAllTrainersPerCourse() {
        TrainerDao tdao = new TrainerDao();
        for (Course course : Course.getAllCourses()) {
            System.out.println("" + course.getCourseId() + ")" + course.getTitle() + "\n  " + course.getStream());
            for (Trainer trainer : tdao.TrainerPerCourse(course)) {
                System.out.println("        *" + trainer.getFirstName() + " " + trainer.getLastName());
            }
        }
    }

    public static void printAllAssignmentPerCourse() {
        AssignmentDao adao = new AssignmentDao();
        for (Course course : Course.getAllCourses()) {
            System.out.println("" + course.getCourseId() + ")" + course.getTitle() + "\n  " + course.getStream());
            for (Assignment assignment : adao.AssignmentPerCourse(course)) {
                System.out.println("     *" + assignment.getTitle());
            }
        }
    }

    public static void printAllAssignmentPerStudent() {
        AssignmentDao adao = new AssignmentDao();
        for (Student student : Student.getAllStudets()) {
            System.out.println(student.getStudentId()+")" + student.getFirstName() + " " + student.getLastName());
            for (Assignment assignment : adao.AssignmentPerStudent(student)) {
                System.out.println("     *" + assignment.getTitle() + "  " + assignment.getDescription()+", For Course: "+assignment.getCourse().getTitle()+" "+assignment.getCourse().getStream());
            }
        }
    }

    static public void printAllStudentThatBelongUpToACourse() {
        StudentDao sdao = new StudentDao();
        for (Student student : Student.getAllStudets()) {
            if (sdao.CoursePerStudent(student).size() > 1) {
                System.out.println(student.getStudentId()+")" + student.getFirstName() + " " + student.getLastName());
                for (Course course : sdao.CoursePerStudent(student)) {
                    System.out.println("     *" + course.getTitle() + " " + course.getStream());
                }
            }
        }
    }
}
