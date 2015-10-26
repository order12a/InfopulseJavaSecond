package lection2;

import java.util.NoSuchElementException;

public class Calculations {

    public double calculate(int a, int b, String argument){
        double result = 0.0;
        try {
            if(!argument.isEmpty()) {
                if (a <= 1000 && a >= -1000 && b >= -1000 && b <= 1000) {
                    switch (argument) {
                        case "+":
                            result =(double) a + (double) b;
                            break;
                        case "-":
                            result = (double) a - (double) b;
                            break;
                        case "*":
                            result = (double) a * (double) b;
                            break;
                        case "/":
                            try {
                                result = a / b;
                            } catch (IllegalArgumentException | ArithmeticException e) {
                                throw new ArithmeticException("Division by zero");
                            }
                            break;
                        default:
                            System.out.println("Incorrect operator is set!");
                    }
                }else {
                    throw new IllegalArgumentException("Input values could not be less -1000 or greater 1000");
                }
            }
            }catch (NullPointerException ex){
                System.out.println("null was set as argument value!");
            }catch (NoSuchElementException e2) {
                System.out.println("Unexpected operator was set.");
            }
        return result;
        }
}
