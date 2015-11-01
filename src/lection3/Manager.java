package lection3;

import lection3.interfaces.Occupation;

/**
 * Created by order on 28.10.15.
 */
public class Manager extends GeneralWorker implements Occupation {

    @Override
    public void executeWork() {
        System.out.println("Managing work.");
    }

    public void delegateWork(GeneralWorker worker) {
        worker.setOccupation(this);
    }

    @Override
    public void clean() {
        System.out.println("No manual work! Only delegation of work for other people.");
    }

}
