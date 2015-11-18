package lection4;

public class ShareKnowledgeTest {

    public static void main(String[] args){
        Worker skilledWorker = new Worker("Ivan");
        skilledWorker.printKnowledge();
        System.out.println(skilledWorker.getKnowledge().hashCode());
        System.out.println(skilledWorker.getKnowledge().getGeneralKnowledge().hashCode());
        System.out.println();

        Worker junior = new Worker("Sandy", true);
        junior.printKnowledge();
        System.out.println();
        junior.selfEducate();
        junior.printKnowledge();
        System.out.println(junior.getKnowledge().hashCode());
        System.out.println();

        System.out.println();
        junior.educate(skilledWorker);
        junior.printKnowledge();
        System.out.println(junior.getKnowledge().hashCode());
        System.out.println(junior.getKnowledge().getGeneralKnowledge().hashCode());
    }
}
