package lection3;

import lection3.interfaces.BasicWork;
import lection3.interfaces.Occupation;

/**
 * Created by order on 28.10.15.
 */
public class WorkerTest {
    public static void main(String [] args){
//        GeneralWorker simpleWorker = new Worker();
//        GeneralWorker simpleEngineer = new Engineer();
//        GeneralWorker manager = new Manager();
//        GeneralWorker ceo = new CEO();
//
//        BasicWork[] workers = new BasicWork[4];
//        workers[0] = simpleWorker;
//        workers[1] = simpleEngineer;
//        workers[2] = manager;
//        workers[3] = ceo;
//        for (BasicWork work: workers){
//            work.clean();
//        }

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
