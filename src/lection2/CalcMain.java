package lection2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by order on 26.10.15.
 */
public class CalcMain {

    public static void main(String [] args){
        boolean flag = true;
        CalcInput calcIn = new CalcInput();
        Scanner scanIn = new Scanner(System.in);
        try {
            while (flag) {
                System.out.println(calcIn.enterDataToCalc());
                System.out.println("");
                try {
                    Runtime.getRuntime().exec("clear");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Enter N to continue.");
                String val = scanIn.next();
                if (val.equalsIgnoreCase("N")) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        }catch (InputMismatchException ex){
            System.out.println("Incorrect input in cycle.");
        }finally {
            scanIn.close();
        }

    }
}
