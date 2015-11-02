package lection3.tests;

import lection3.CEO;
import lection3.Engineer;
import lection3.Manager;
import lection3.Worker;

public class WorkerTestDelegation {

    public static void main(String[] args){
        Worker worker = new Worker();
        Engineer engineer = new Engineer();
        Manager manager = new Manager();
        CEO ceo = new CEO();

//        worker.delegateWork(engineer);
//        engineer.getOccupation().executeWork();
//
        engineer.delegateWork(manager);
        manager.executeWork();
        System.out.println();
        worker.delegateWork(ceo);
        ceo.executeWork();

    }
}
