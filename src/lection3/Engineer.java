package lection3;

import lection3.interfaces.Occupation;

public class Engineer extends GeneralWorker implements Occupation {
    private String level;

    public Engineer(){
        this("Vasko", "Electric", 700, "1st level");
    }

    public Engineer(String name, String role, int salary, String level) {
        super(name, role, salary);
        if (!(level == null)){
            if (!(level.isEmpty())){
                this.level = level;
            }else {
                throw new IllegalArgumentException("Level variable was not set correctly.");
            }
        }else {
            throw new NullPointerException("Level was set to null but String required");
        }
    }

    public Engineer(String name, String role, int salary) {
        super(name, role, salary);
    }

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

    @Override
    public int compareTo(GeneralWorker worker) {
        return Integer.compare(getSalary(), worker.getSalary());
    }
}
