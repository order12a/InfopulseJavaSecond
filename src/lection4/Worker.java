package lection4;

import java.util.Arrays;
import java.util.Random;

public class Worker extends Employee{
    private Knowledge knowledge;

    /*
     * Default constructor for skilled worker with knowledge
     */

    public Worker(String name){
        super(name);
        this.knowledge = new Knowledge(new GeneralKnowledge(), new PhysicKnowledge());
    }

    /*
     *Constructor for new worker, e.g. junior
     */

    public Worker(String name , boolean isNew) {
        super(name);
        if (isNew){
            this.knowledge = null;
        }else {
            System.out.println("This is constructor for junior.");
        }
    }

    /*
     *Constructor that totally receive knowledge from skilled worker
     */

    public Worker(String name, Worker worker){
        super(name);
        if (worker != null){
            this.setKnowledge(worker.getKnowledge());
        }else {
            throw new NullPointerException("Worker can not be null.");
        }
    }

    /*
     * Prints all knowledge of worker
     */
    public void printKnowledge(){
        if(knowledge != null){
            System.out.println("General knowledge of " + this.getName());
            for (String generalKnowledge: knowledge.generalKnowledge){
                System.out.println(generalKnowledge);
            }
            System.out.println("Physic knowledge of " + this.getName());
            for (String physicKnowledge: knowledge.getPhysicKnowledge()){
                System.out.println(physicKnowledge);
            }
        }else {
            System.out.println("Newbie " + this.getName() +  "! This worker should learn a lot.");
        }
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }

    public Detail copyDetail(Detail detail){
        Detail detail1;
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        if (randomNumber <= 5){
            return new Detail("5", 5, 5);
        }else {
            try {
                detail =  detail.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return detail;
     }

    public class Knowledge{
        private String[] generalKnowledge;
        private String[] physicKnowledge;

        public Knowledge(GeneralKnowledge generalKnowledge, PhysicKnowledge physicKnowledge) {
            this.generalKnowledge = generalKnowledge.getGeneralKnowledge();
            this.physicKnowledge = physicKnowledge.getPhysicKnowledge();
        }
        public Knowledge(Knowledge knowledge){
            this.setGeneralKnowledge(knowledge.getGeneralKnowledge());
            this.setPhysicKnowledge(knowledge.getPhysicKnowledge());
        }
        public String[] getPhysicKnowledge() {
            return physicKnowledge;
        }

        public void setPhysicKnowledge(String[] physicKnowledge) {
            this.physicKnowledge = physicKnowledge;
        }

        public String[] getGeneralKnowledge() {
            return generalKnowledge;
        }

        public void setGeneralKnowledge(String[] generalKnowledge) {
            this.generalKnowledge = generalKnowledge;
        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(getGeneralKnowledge());
            result = 31 * result + Arrays.hashCode(getPhysicKnowledge());
            return result;
        }
    }

    public void educate(Worker worker){
        this.setKnowledge(worker.getKnowledge());
    }

    public void selfEducate(){
        String [] test = {"Test", "Test", "test"};
        GeneralKnowledge generalKnowledge = new GeneralKnowledge();
        generalKnowledge.setGeneralKnowledge(test);
        PhysicKnowledge physicKnowledge = new PhysicKnowledge();
        physicKnowledge.setPhysicKnowledge(test);
        this.setKnowledge(new Knowledge(generalKnowledge, physicKnowledge));
    }

//    public Worker receiveKnowledge(Worker worker){
//        System.out.println(" Name: " + this.getName() + "\n");
//        return new Worker(this.getName(), worker);
//    }
}
