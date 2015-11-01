package lection3;

import lection3.interfaces.Occupation;

/**
 * Created by order on 28.10.15.
 */
public class CEO extends Manager{

//    private Occupation del = null;


    @Override
    public void drink() {
        super.drink();
        System.out.println("CEO drinks Absolut!");
    }

    @Override
    public void clean() {
        super.clean();
        System.out.println("Not only delegate work but may require report of executed tasks.");
    }

    @Override
    public void delegateWork(GeneralWorker worker) {
        super.delegateWork(this);
    }

    @Override
    public void executeWork() {
        super.executeWork();
        System.out.println("Chief Officer at this facility!");
    }
}
