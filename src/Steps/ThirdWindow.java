package Steps;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Scanner;
import myindividualproject.Assignment;
import myindividualproject.Course;
import myindividualproject.Student;
import myindividualproject.Trainer;

public class ThirdWindow {

    static Scanner input = new Scanner(System.in);

    public static void shomeThirdWindow() {

        boolean exit = false;
        while (!exit) {
            System.out.println("======================");
            System.out.println("PRESS 0. FOR <BACK>");
            System.out.println("PRESS 1. FOR STUDENTS PER COURSE");
            System.out.println("PRESS 2. FOR TRAINERS PER COURSE");
            System.out.println("PRESS 3. FOR ASSIGNMENTS PER COURSE");
            System.out.println("PRESS 4. FOR ASSIGNMENTS PER STUDENTS");
            System.out.println("PRESS 5. FOR STUDENT THAT BELONG TO MORE THAN ONE COURSES");
            switch (input.next()) {
                case "0":
                    exit = true;
                    break;
                //PRINT STUDENT PER COURSE
                case "1":
                    Search.printAllStudentsPerCourse();
                    break;
                // PRINT TRAINERS PER COURSE
                case "2":
                    Search.printAllTrainersPerCourse();
                    break;
                //PRINT ASSINGMENT PER COURSE
                case "3":
                    Search.printAllAssignmentPerCourse();
                    break;
                //ASSIGNMENTS PER STUDENTS
                case "4":
                    Search.printAllAssignmentPerStudent();
                    break;
                //A LIST THAT STUDENT BELONG UP TO A COURSE
                case "5":
                    Search.printAllStudentThatBelongUpToACourse();
                    break;
                default:
                    System.out.println("PLEASE GIVE THE RIGHT NUMBER");
                    break;
            }

        }
    }

    public static void showMeTheThirdWindowWithInput() {
        boolean exit = false;
        while (!exit) {
            System.out.println("======================");
            System.out.println("PRESS 0. FOR <BACK>");
            System.out.println("PRESS 1. PRINT ALL STUDENTS");
            System.out.println("PRESS 2. PRINT ALL TRAINERS");
            System.out.println("PRESS 3. PRINT ALL ASSIGNMENTS");
            System.out.println("PRESS 4. PRINT ALL COURSES");
            System.out.println("PRESS 5. FOR STUDENTS PER COURSE");
            System.out.println("PRESS 6. FOR TRAINERS PER COURSE");
            System.out.println("PRESS 7. FOR ASSIGNMENTS PER COURSE");
            System.out.println("PRESS 8. FOR ASSIGNMENTS PER STUDENTS");
            System.out.println("PRESS 9. FOR STUDENT THAT BELONG TO MORE THAN ONE COURSES");
            switch (input.next()) {
                case "0":
                    exit = true;
                    break;
                //PRINT ALL STUDENTS
                case "1":
                    Search.printAllStudents();
                    break;
                //PRINT ALL TRAINERS
                case "2":
                    Search.printAllTrainers();
                    break;
                //PRINT ALL ASSIGNMENTS
                case "3":
                    Search.printAllAssignments();
                    break;
                //PRINT ALL COURSES
                case "4":
                    Search.printAllCourses();
                    break;
                //PRINT STUDENTS PER COURSE
                case "5":
                    Search.printAllStudentsPerCourse();
                    break;
                //PRINT TRAINERS PER COURSE
                case "6":
                    Search.printAllTrainersPerCourse();
                    break;
                //PRINT ASSIGNMENT PER COURSE
                case "7":
                    Search.printAllAssignmentPerCourse();
                    break;
                //PRINT ASSIGNMENT PER STUDENT
                case "8":
                    Search.printAllAssignmentPerStudent();                     
                    break;
                //A LIST THAT STUDENT BELONG UP TO A COURSE
                case "9":
                    Search.printAllStudentThatBelongUpToACourse();
                    break;
                default:
                    System.out.println("PLEASE GIVE THE RIGHT NUMBER");
                    break;
            }

        }
    }

}
