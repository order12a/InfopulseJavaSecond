package lection3;

import lection3.interfaces.Occupation;

public class Worker extends GeneralWorker implements Occupation {
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
        System.out.println("Executing manual work.");
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
}
