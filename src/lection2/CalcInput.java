package lection2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CalcInput {

    public double enterDataToCalc(){
        int a = 0;
        int b = 0;
        String operator = "";
        double result = 0;
        Calculations calc = new Calculations();
        Scanner scanIn = new Scanner(System.in);
            try {
                System.out.println("Enter Math operator.");
                operator = scanIn.next();

                System.out.println("Enter a value.");
                a = scanIn.nextInt();

                System.out.println("Enter b value");
                b = scanIn.nextInt();
                result = calc.calculate(a, b, operator);
            } catch (InputMismatchException e2){
                System.out.println("Incorrect input");
            }
//            catch (NoSuchElementException e2){
//                System.out.println("Incorrect input");
//            }
//            finally {
//                scanIn.close();
//            }
        return result;
    }
}
