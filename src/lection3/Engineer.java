package lection3;

import lection3.interfaces.Occupation;
import lection3.interfaces.TurnerWork;

public class Engineer extends GeneralWorker implements Occupation, TurnerWork {
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
        if (getOccupation() != null){
            getOccupation().executeWork();
        }else {
            executeTurnerWork();
        }
    }

    @Override
    public void delegateWork(GeneralWorker worker) {
        worker.setOccupation(this);
    }

    @Override
    public void measure(TurnerInstruments instrument) {
        System.out.println("Measuring with instrument " + instrument.name());
    }

    @Override
    public int compareTo(GeneralWorker worker) {
        return Integer.compare(getSalary(), worker.getSalary());
    }

    @Override
    public void executeTurnerWork() {
        System.out.println("Executing turner work using instruments: ");
        for (TurnerInstruments instrument: TurnerInstruments.values()){
            System.out.println(instrument.toString());
        }
    }
}
