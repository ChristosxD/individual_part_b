
package myindividualproject;

import Steps.FirstWindow;
import Steps.SecondWindow;
import Steps.ThirdWindow;
import Steps.Utilitis;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import jdk.nashorn.internal.objects.annotations.Getter;


public class MyIndividualProject {


    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
        
        while (true) {
            FirstWindow.showMeFirstMessage();
            switch (Utilitis.ifWriteString()) {
                case 1:
                    SecondWindow.showMeSecondMessage();
                    break;
                case 2:
                    SecondWindow.showMeSecondWindowWithInput();
                   break;
                default:
                    break;
            }
        }
    }

}
