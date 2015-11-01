package lection3;

import lection3.interfaces.Occupation;

/**
 * Created by order on 28.10.15.
 */
public class Engineer extends GeneralWorker implements Occupation {

    @Override
    public void clean() {
        System.out.println("No manual work! Using different devices instead. ");
    }

    @Override
    public void executeWork() {
        System.out.println("Engineering at this factory.");
    }

    @Override
    public void delegateWork(GeneralWorker worker) {
        worker.setOccupation(this);
    }
}
