package myindividualproject;

import Dao.CourseDao;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class Course {

    // Variables
    private int courseId;
    private String title;
    private String stream;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Assignment> assignments = new ArrayList<>();
    private ArrayList<Trainer> alltrainers = new ArrayList<>();

    
    public Course() {

    }

    public Course(int courseId,String title, String stream, String type,LocalDate startDate, LocalDate endDate) {
        this.courseId = courseId;
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;

    }

 
    //Fill list with Student per course
    public void addStudent(Student student) {
        this.students.add(student);
    }

    
    //Fill list with Trainers per course
    public void addTrainers(Trainer trainer) {
        alltrainers.add(trainer);
    }

    
    //Fill list with Assignments per course
    public void addAssignmets(Assignment assisnment) {
        this.assignments.add(assisnment);
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String Stream) {
        this.stream = Stream;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public static ArrayList<Course> getAllCourses() {
        CourseDao cdao = new CourseDao();
        return cdao.getAllCourses();
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Trainer> getAlltrainers() {
        return alltrainers;
    }

    public void setAlltrainers(ArrayList<Trainer> alltrainers) {
        this.alltrainers = alltrainers;
    }

    
    @Override
    public String toString() {
        return courseId +")" + title + "\n Stream : " + stream + "\n startDate: " + startDate + "\n endDate: " + endDate;
    }




}
