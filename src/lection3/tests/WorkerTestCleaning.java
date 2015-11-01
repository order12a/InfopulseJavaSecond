package lection3.tests;

import lection3.*;
import lection3.interfaces.BasicWork;
import lection3.interfaces.Occupation;

/**
 * Created by order on 28.10.15.
 */
public class WorkerTestCleaning {
    public static void main(String [] args){
        GeneralWorker simpleWorker = new Worker();
        GeneralWorker simpleEngineer = new Engineer();
        GeneralWorker manager = new Manager();
        GeneralWorker ceo = new CEO();

        BasicWork[] workers = new BasicWork[4];
        workers[0] = simpleWorker;
        workers[1] = simpleEngineer;
        workers[2] = manager;
        workers[3] = ceo;
        for (BasicWork work: workers){
            work.clean();
        }
    }
}
