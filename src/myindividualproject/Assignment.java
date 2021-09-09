
package myindividualproject;

import Dao.AssignmentDao;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;


public class Assignment {
    private int assignmentId;
    private String title;
    private String description;
    private LocalDate subDateTime;
    private int oralMark;
    private int totalMark;
    private Course course;
    private static ArrayList<Assignment> assign = new ArrayList<>();
    
    public Assignment() {
    }

    public Assignment(int assignmentId, String title, String description, LocalDate subDateTime, int oralMark, int totalMark, Course course) {
        this.assignmentId = assignmentId;
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
        this.course = course;
    }

    
    public Assignment(int assignmentId, String title, String description, LocalDate subDateTime, int oralMark, int totalMark) {
        this.assignmentId = assignmentId;
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    
    public Assignment(String title, String description, LocalDate subDateTime, int oralMark, int totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }


   public int getWeekOfTheYear(){
   return this.subDateTime.get(WeekFields.ISO.weekOfYear());
   }
   
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDateTime = subDateTime;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public static ArrayList<Assignment> getAssign() {
        AssignmentDao adao =  new AssignmentDao();
        return adao.getAllAssignments();
    }

    @Override
    public String toString() {
        return assignmentId +")" + title + "\n description is: " + description + "\n subDateTime is: " + subDateTime ;
    }
    
}
