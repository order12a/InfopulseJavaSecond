package lection3;

import lection3.interfaces.Occupation;

public class Manager extends GeneralWorker implements Occupation {
    public String graduation;

    public Manager(){
        this("John", "Product manager", 1200, "MBA");
    }

    public Manager(String name, String role, int salary, String graduation) {
        super(name, role, salary);
        if (graduation != null){
            if (!graduation.isEmpty()){
                this.graduation = graduation;
            }else {
                throw new IllegalArgumentException("Graduation could not be empty.");
            }
        }else {
            throw new NullPointerException("Please, remember about managers graduation.");
        }
    }

    public Manager(String name, String role, int salary) {
        super(name, role, salary);
    }

    @Override
    public int compareTo(GeneralWorker worker) {
        return Integer.compare(getSalary(), worker.getSalary());
    }

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
