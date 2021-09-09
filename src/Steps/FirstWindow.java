package Steps;

import Dao.GenericDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import myindividualproject.Student;

public class FirstWindow {

    public static void showMeFirstMessage() {

        System.out.println("WELCOME TO MY PROJECT");
        System.out.println("======================");
        System.out.println("WOULD YOU LIKE TO CHECK MY DATA,(OPTION A)");
        System.out.println("OR");
        System.out.println("WOULD YOU LIKE TO WRITE YOURS ? (OPTION B)");
        System.out.println("======================");
        System.out.println("PRESS '1' FOR OPTION A");
        System.out.println("PRESS '2' FOR OPTION B");
    }
}
