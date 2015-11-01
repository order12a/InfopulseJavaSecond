package lection3.tests;

import lection3.CEO;
import lection3.Engineer;
import lection3.Manager;
import lection3.Worker;

public class WorkerTestDelegation {

    public static void main(String[] args){
        Worker worOc = new Worker();
        Engineer eng = new Engineer();
        Manager mang = new Manager();
        CEO ceo2 = new CEO();

        mang.delegateWork(worOc);
        worOc.getOccupation().executeWork();
        System.out.println();

        try {
            worOc.delegateWork(mang);
            mang.getOccupation().executeWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        eng.delegateWork(mang);
        mang.getOccupation().executeWork();
        System.out.println();

        ceo2.delegateWork(worOc);
        worOc.getOccupation().executeWork();
        System.out.println();

        try {
            worOc.delegateWork(ceo2);
            ceo2.getOccupation().executeWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            worOc.delegateWork(manager);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        mang.delegateWork(eng);
//        ceo2.delegateWork(worOc);
        System.out.println();
    }
}
