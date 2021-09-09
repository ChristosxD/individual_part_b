package myindividualproject;

import Dao.StudentDao;
import java.time.LocalDate;
import java.util.ArrayList;

public class Student {
    //Variables
    private int studentId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBday;
    private int tuitionFees;
    private static ArrayList<Student> allStudets = new ArrayList<>();
    
    public Student() {
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(int studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(int studentId, String firstName, String lastName, LocalDate dateOfBday, int tuitionFees) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBday = dateOfBday;
        this.tuitionFees = tuitionFees;
    }

    public Student(String firstName, String lastName, LocalDate dateOfBday, int tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBday = dateOfBday;
        this.tuitionFees = tuitionFees;

    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void getAssignmets(Assignment assignmet) {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBday() {
        return dateOfBday;
    }

    public void setDateOfBday(LocalDate dateOfBday) {
        this.dateOfBday = dateOfBday;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public static ArrayList<Student> getAllStudets() {
        StudentDao sdao = new StudentDao();
        return sdao.getAllStudents();
    }


    

    @Override
    public String toString() {
        return studentId+")" + firstName + " " + lastName + "\n   BIRTHDAY: " + dateOfBday + "\n   TUITION FEES: " + tuitionFees + "\n";

    }

}
