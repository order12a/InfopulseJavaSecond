package lection3;

public class Robot extends GeneralWorker{
    @Override
    public void clean() {
        System.out.println("Default cleaning by robot.");
    }

    @Override
    public int compareTo(GeneralWorker o) {
        return 0;
    }

    public Robot(){
        this("Big Rob", "Robot", 1);
    }

    public Robot(String name, String role, int salary) {
        super(name, role, salary);
    }

    public void replaceWorker(GeneralWorker worker){
        if(worker instanceof Worker){
            ((Worker) worker).executeWork();
        }if (worker instanceof Engineer){
            ((Engineer) worker).executeWork();
        }if (worker instanceof Manager && !(worker instanceof CEO)){
            ((Manager) worker).executeWork();
        }if (worker instanceof CEO){
            ((CEO) worker).executeWork();
        }if (worker instanceof Robot){
            System.out.println("Error I need correct role to replace.");
        }
//        else {
//            throw new IllegalArgumentException("Undefined type of worker was set. Replace argument or extend Robot.class");
//        }
    }
}
