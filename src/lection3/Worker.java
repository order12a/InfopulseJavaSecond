package lection3;

import lection3.interfaces.Occupation;

/**
 * Created by order on 28.10.15.
 */
public class Worker extends GeneralWorker implements Occupation {


    @Override
    public void clean() {
        System.out.println("Cleaning all territory manually.");
    }

    @Override
    public void executeWork() {
        System.out.println("Executing manual work.");
    }


    public void delegateWork(GeneralWorker worker) throws Exception {
        if (worker.getClass().getName().equalsIgnoreCase("CEO")){
            System.out.println("Unable work as CEO");;
        }else{
            worker.setOccupation(this);
        }
    }
}
