
package myindividualproject;

import Dao.TrainerDao;
import java.util.ArrayList;


public class Trainer {
//Variables
private int trainerId;    
private String firstName;
private String lastName;
private String subject;
private static ArrayList<Trainer> allTrainers = new ArrayList<>();


    public Trainer() {
    }

    public Trainer(int trainerId, String firstName, String lastName, String subject) {
        this.trainerId = trainerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public static ArrayList<Trainer> getAllTrainers() {
       TrainerDao tdao = new TrainerDao();
        return tdao.getAllTrainers();
    }



    @Override
    public String toString() {
        return trainerId +")" + firstName + "\n " + lastName + "\n    *" + subject;
    }

 
    
}
