package Steps;

import Dao.AssignmentDao;
import Dao.CourseDao;
import Dao.StudentDao;
import Dao.TrainerDao;
//import static Steps.FirstWindow.input;
import static Steps.ThirdWindow.input;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import myindividualproject.Assignment;
import myindividualproject.Course;
import myindividualproject.Student;
import myindividualproject.Trainer;

/*IN THIS CLASS, 

*I HAVE ALL THE METHODS

WITH INPUT*/
public class Utilitis {

    static Scanner input = new Scanner(System.in);

    public static int ifWriteString() {
        int onlyNumber;

        while (true) {
            try {
                onlyNumber = Integer.parseInt(input.next());
                break;
            } catch (NumberFormatException xxx) {
                System.out.println("PLEASE GIVE THE RIGHT NUMBER ");
            }
        }
        return onlyNumber;
    }

    public static int ifWriteString(int minimum, int maximum) {
        boolean isntvalid = true;
        int i = 0;
        while (isntvalid) {
            i = ifWriteString();
            if (i < minimum || i > maximum) {
                System.out.println("PLEASE GIVE ME THE RIGHT NUMBER");
            } else {
                isntvalid = false;
            }
        }

        return i;
    }

    public static String onlyString() {

        boolean exit = false;
        String string = " ";
        while (!exit) {
            string = input.next();
            input.nextLine();
            if (Pattern.matches("^[a-zA-Z]+$", string) == true) {
                exit = true;

            } else {
                System.out.println("PLEASE GIVE ME A RIGHT NAME: ");
            }

        }
        return string;
    }

    public static void creatStudentWithInput() {
        StudentDao sdao = new StudentDao();
        while (true) {
            System.out.println("GIVE ME FIRST NAME: ");
            Student creatStudent = new Student();
            creatStudent.setFirstName(Utilitis.onlyString());
            System.out.println("GIVE ME LAST: ");
            creatStudent.setLastName(Utilitis.onlyString());
            System.out.println("GIVE ME DATE OF BIRTHDAY: ");
            creatStudent.setDateOfBday(getLocalDate());
            System.out.println("GIVE ME TUITION FEES:  ");
            creatStudent.setTuitionFees(Utilitis.ifWriteString());
            sdao.saveStudent(creatStudent);

            break;
        }
        System.out.println("======================");
        System.out.println(" ");
    }

    public static void creatTrainerWithInput() {
        TrainerDao tdao = new TrainerDao();
        while (true) {
            System.out.println("GIVE ME FIRST NAME: ");
            Trainer creatTrainer = new Trainer();
            creatTrainer.setFirstName(Utilitis.onlyString());
            System.out.println("GIVE ME LAST NAME :");
            creatTrainer.setLastName(Utilitis.onlyString());
            System.out.println("GIVE ME SUBJECT: ");
            creatTrainer.setSubject(Utilitis.onlyString());
            tdao.saveTrainer(creatTrainer);
            break;
        }
        System.out.println("======================");
        System.out.println(" ");
    }

    public static void creatAssignmentWithInput() {
        AssignmentDao adao = new AssignmentDao();
        while (true) {
            System.out.println("GIVE ME TITLE: ");
            Assignment creatAssignment = new Assignment();
            creatAssignment.setTitle(Utilitis.onlyString());
            System.out.println("GIVE ME DESCRIPTION: ");
            creatAssignment.setDescription(Utilitis.onlyString());
            System.out.println("GIVE ME THE SUBMISSION: ");
            creatAssignment.setSubDateTime(getLocalDate());
            System.out.println("GIVE ME ORAL MARK: ");
            creatAssignment.setOralMark(Utilitis.ifWriteString());
            System.out.println("GIVE ME TOTAL MARK: ");
            creatAssignment.setTotalMark(Utilitis.ifWriteString());
            adao.saveAssignment(creatAssignment);

            break;
        }
        System.out.println("======================");
        System.out.println(" ");

    }

    public static void creatCourseWithInput() {
        boolean exit = false;
        CourseDao cdao = new CourseDao();
        while (!exit) {
            System.out.println("GIVE ME TITLE:");
            Course creatCourse = new Course();
            creatCourse.setTitle(input.next());
            System.out.println("GIVE ME THE STEAM: ");
            creatCourse.setStream(input.next());
            System.out.println("GIVE ME THE START DATE: ");
            creatCourse.setStartDate(getLocalDate());
            System.out.println("GIVE ME THE END DATE: ");
            creatCourse.setEndDate(getLocalDate());
            cdao.saveCourse(creatCourse);
            break;
        }

        System.out.println("======================");
        System.out.println(" ");

    }

    /**
     * ADD A STUDENT TO A COURSE
     */
    public static void addStudentToACourse() {
        for (int i = 0; i < Course.getAllCourses().size(); i++) {
            System.out.println(i + 1 + " " + Course.getAllCourses().get(i).toString());
        }
        System.out.println("");
        System.out.println("IN WHICH COURSE WOULD YOU LIKE TO ADD STUDENTS?");
        int courseNumber = ifWriteString(1, Course.getAllCourses().size());
        Course course = Course.getAllCourses().get(courseNumber - 1);
        StudentDao stdao = new StudentDao();
        ArrayList<Student> allStudents = new ArrayList(Student.getAllStudets());
        boolean exit = false;
        while (!exit) {
            System.out.println("PLEASE CHOOSE A STUDENT");
            for (int i = 0; i < allStudents.size(); i++) {
                System.out.println(i + 1 + " " + allStudents.get(i).getFirstName() + " " + allStudents.get(i).getLastName());
            }
            int studentNumber = ifWriteString(1, allStudents.size());
            Student student = allStudents.get(studentNumber - 1);
            stdao.insertStudentToACourse(student, course);
            if (allStudents.size() > 0) {
                System.out.println("WOULD YOU LIKE ADD MORE STUDENTS?");
                System.out.println("PRESS 1. FOR YES");
                System.out.println("PRESS 2. FOR NO");
                if (ifWriteString(1, 2) == 2) {
                    exit = true;
                }
            } else {
                exit = true;
            }
        }
    }

    /**
     * ADD TRAINER TO A COURSE
     */
    public static void addTrainerToACourse() {
        for (int i = 0; i < Course.getAllCourses().size(); i++) {
            System.out.println(i + 1 + " " + Course.getAllCourses().get(i).toString());
        }
        System.out.println("");
        System.out.println("IN WHICH COURSE WOULD YOU LIKE TO ADD TRAINER?");
        int courseNumber = ifWriteString(1, Course.getAllCourses().size());
        Course course = Course.getAllCourses().get(courseNumber - 1);
        TrainerDao tdao = new TrainerDao();
        ArrayList<Trainer> allTrainers = new ArrayList(Trainer.getAllTrainers());
        boolean exit = false;
        while (!exit) {
            System.out.println("PLEASE CHOOSE A TRAINER");
            for (int i = 0; i < allTrainers.size(); i++) {
                System.out.println(i + 1 + " " + allTrainers.get(i).getFirstName() + " " + allTrainers.get(i).getLastName());
            }
            int trainerNumber = ifWriteString(1, allTrainers.size());
            Trainer trainer = allTrainers.get(trainerNumber - 1);
            tdao.insertTrainerToACourse(trainer, course);
            if (allTrainers.size() > 0) {
                System.out.println("WOULD YOU LIKE ADD MORE TRAINER?");
                System.out.println("PRESS 1. FOR YES");
                System.out.println("PRESS 2. FOR NO");
                if (ifWriteString(1, 2) == 2) {
                    exit = true;
                }
            } else {
                exit = true;
            }
        }

    }

    /**
     * ADD AN ASSIGNMENT TO A COURSE
     */
    public static void addAssignmentToACourse() {
        for (int i = 0; i < Course.getAllCourses().size(); i++) {
            System.out.println(i + 1 + " " + Course.getAllCourses().get(i).toString());
        }
        System.out.println("");
        System.out.println("IN WHICH COURSE WOULD YOU LIKE TO ADD ASSIGNMENT?");
        int courseNumber = ifWriteString(1, Course.getAllCourses().size());
        Course course = Course.getAllCourses().get(courseNumber - 1);
        AssignmentDao adao = new AssignmentDao();
        ArrayList<Assignment> allAssignment = new ArrayList(Assignment.getAssign());
        boolean exit = false;
        while (!exit) {
            System.out.println("PLEASE CHOOSE AN ASSIGNMENT");
            for (int i = 0; i < allAssignment.size(); i++) {
                System.out.println(i + 1 + " " + allAssignment.get(i).getTitle() + " " + allAssignment.get(i).getDescription());
            }
            int assignmentNumber = ifWriteString(1, allAssignment.size());
            Assignment assignment = allAssignment.get(assignmentNumber - 1);
            adao.insertAssignmentToACourse(course,assignment);
            if (allAssignment.size() > 0) {
                System.out.println("WOULD YOU LIKE ADD MORE ASSIGNMENT");
                System.out.println("PRESS 1. FOR YES");
                System.out.println("PRESS 2. FOR NO");
                if (ifWriteString(1, 2) == 2) {
                    exit = true;
                }
            } else {
                exit = true;
            }
        }
    }

    /**
     * THIS METHOD CHECK IF USER, GIVE WRONG DATE
     */
    public static LocalDate getLocalDate() {
        LocalDate result = LocalDate.now();
        boolean exit = true;
        while (exit) {
            try {
                String date = input.next();
                result = LocalDate.parse(date);
                exit = false;
            } catch (java.time.DateTimeException e) {
                System.out.println("WRONG DATE, TRY AGAIN. (YYYY-MM-DD)");
            }
        }
        return result;
    }

}
