package lection3;

public class Robot{
    private String name;
    private String role;

    public Robot(){
        this("Big Rob", "Robot");
    }

    public Robot(String name, String role) {
        this.name = name;
        this.role = role;
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
        }else {
            throw new IllegalArgumentException("Undefined type of worker was set. Replace argument or extend Robot.class");
        }
    }
}
