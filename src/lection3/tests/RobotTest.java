package lection3.tests;

import lection3.*;

public class RobotTest {

    public static void main(String [] args){
        Robot robot = new Robot();

        Worker worker = new Worker();
        Worker worker1 = new Worker("Alex", "mounter", 400);
        Engineer engineer = new Engineer();
        Engineer engineer1 = new Engineer("Newton", "Diagnostic engineer", 800, "2nd");
        Manager manager = new Manager();
        CEO ceo = new CEO();

        robot.replaceWorker(worker);
        robot.replaceWorker(engineer);
        robot.replaceWorker(manager);
        robot.replaceWorker(ceo);
        robot.replaceWorker(worker1);
        robot.replaceWorker(engineer1);
    }
}
