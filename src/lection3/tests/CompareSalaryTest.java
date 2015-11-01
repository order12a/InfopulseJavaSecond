package lection3.tests;

import lection3.*;

import java.util.ArrayList;
import java.util.Collections;

public class CompareSalaryTest {

    public static void main(String [] args){
        ArrayList<GeneralWorker> employees = new ArrayList<>();
        Worker worker = new Worker();
        Worker worker1 = new Worker("Alex", "mounter", 400);
        Engineer engineer = new Engineer();
        Engineer engineer1 = new Engineer("Newton", "Diagnostic engineer", 800, "2nd");
        Manager manager = new Manager();
        CEO ceo = new CEO();

        employees.add(worker);
        employees.add(ceo);
        employees.add(worker1);
        employees.add(engineer);
        employees.add(manager);
        employees.add(engineer1);

        System.out.println();
        for (GeneralWorker wk: employees){
            System.out.println("Employee salary - " + wk.getSalary());
        }
        System.out.println();

        Collections.sort(employees);
        for (GeneralWorker wk: employees){
            System.out.println("Employee salary - " + wk.getSalary());
        }
    }
}
