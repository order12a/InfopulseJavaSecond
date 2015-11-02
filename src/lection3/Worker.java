package lection3;

import lection3.interfaces.LocksmithWork;
import lection3.interfaces.Occupation;

public class Worker extends GeneralWorker implements Occupation, LocksmithWork {
    public Worker(){
        this("Vanko", "cleaner", 300);
    }

    public Worker(String name, String role, int salary) {
        super(name, role, salary);
    }

    @Override
    public void clean() {
        System.out.println("Cleaning all territory manually.");
    }

    @Override
    public void executeWork() {
        if(getOccupation() != null){
            getOccupation().executeWork();
        }else {
            executeLocksmithWork();
        }
    }


    @Override
    public void drill(Instruments instrument) {
        System.out.println("Drilling using " + instrument.name());
    }

    public void delegateWork(GeneralWorker worker){
        if (worker instanceof CEO){
            System.out.println("Unable work as CEO");
        }else{
            worker.setOccupation(this);
        }
    }

    @Override
    public int compareTo(GeneralWorker worker) {
        return Integer.compare(getSalary(), worker.getSalary());
    }

    @Override
    public void executeLocksmithWork() {
        System.out.println("Executing locksmith work using instruments:");
        for (Instruments instrument : Instruments.values()){
            System.out.println(instrument.toString());
        }
    }
}
