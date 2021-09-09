package Steps;

import java.util.Scanner;
import myindividualproject.Assignment;
import myindividualproject.Course;
import myindividualproject.Student;
import myindividualproject.Trainer;

public class SecondWindow {

    static Scanner input = new Scanner(System.in);

    public static void showMeSecondMessage() {
      

        boolean exit = false;
        while (!exit) {
            System.out.println("======================");
            System.out.println("PRESS 0. FOR <BACK>");
            System.out.println("PRESS 1. FOR PRINT ALL STUDENTS");
            System.out.println("PRESS 2. FOR PRINT ALL ASSIGNMENTS");
            System.out.println("PRESS 3. FOR PRINT ALL TRAINERS");
            System.out.println("PRESS 4. FOR PRINT ALL COURSES");
            System.out.println("PRESS 5. FOR MORE DETAILS");
            switch (input.next()) {
                case "0":
                        exit = true;
                    break;
                case "1":
                    for (Student student : Student.getAllStudets()) {
                        System.out.println(student.toString());
                    }
                    break;
                case "2":
                    for (Assignment assignmets : Assignment.getAssign()) {
                        System.out.println(assignmets.toString());
                    }
                    break;
                case "3":
                    for (Trainer trainers : Trainer.getAllTrainers()) {
                        System.out.println(trainers.toString());
                    }
                    break;
                case "4":
                    for (Course course : Course.getAllCourses()) {
                        System.out.println(course.toString());
                    }
                    break;
                case "5":
                    ThirdWindow.shomeThirdWindow();
                    break;

                default:
                    System.out.println("PLEASE GIVE THE RIGHT NUMBER");
                    break;
            }

        }
    }

    public static void showMeSecondWindowWithInput() {
        
        boolean exit = false;
        while (!exit) {
            System.out.println("FOR <BACK> PRESS 0.");
            System.out.println("FOR CREAT STUDENT PRESS 1.");
            System.out.println("FOR CREAT TRAINER PRESS 2.");
            System.out.println("FOR CREAT ASSIGNMENT PRESS 3.");
            System.out.println("FOR CREAT COURSE PRESS 4.");
            System.out.println("ADD STUDENT TO A COURSE 5.");
            System.out.println("ADD TRAINER TO A COURSE 6.");
            System.out.println("ADD ASSIGNMENT TO A COURSE 7.");
            System.out.println("FOR MORE DETAILS PRESS 8. ");
            switch (Utilitis.ifWriteString(0,8)) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    Utilitis.creatStudentWithInput();
                    break;
                case 2:
                    Utilitis.creatTrainerWithInput();
                    break;
                case 3:
                    Utilitis.creatAssignmentWithInput();
                    break;
                case 4:
                    Utilitis.creatCourseWithInput();
                    break;
                case 5:   
                   if(Student.getAllStudets().size() > 0 && Course.getAllCourses().size() > 0){
                    Utilitis.addStudentToACourse();
                   }
                   else{
                       System.out.println("YOU SOULD CREATE STUDENT AND COURSE");
                       System.out.println("GO TO CREATE A STUDENT OR A COURSE");
                       System.out.println("======================");
                   }
                    break;
                case 6:
                    if(Trainer.getAllTrainers().size() > 0 && Course.getAllCourses().size() > 0){
                    Utilitis.addTrainerToACourse();
                    }
                    else{
                       System.out.println("YOU SOULD CREATE TRAINER AND COURSE");
                       System.out.println("GO TO CREATE A TRAINER OR A COURSE");
                       System.out.println("======================");
                   }
                    break;
                case 7:
                   if(Assignment.getAssign().size() > 0 && Course.getAllCourses().size() > 0){
                    Utilitis.addAssignmentToACourse();
                   }
                   else{
                       System.out.println("YOU SOULD CREATE ASSIGNMENT AND COURSE");
                       System.out.println("GO TO CREATE AN ASSIGNMENT OR A COURSE");
                       System.out.println("======================");
                   }
                    break;   
                case 8:
                   ThirdWindow.showMeTheThirdWindowWithInput();
                    break;
                default:
                    System.out.println("PLEASE GIVE THE RIGHT NUMBER");
                    break;
            }
        }
    }

  
    
    
    
    
    
    
    
    
}
