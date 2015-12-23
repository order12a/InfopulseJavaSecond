package lection16;

import java.util.LinkedList;

public class TrainTest {
    public static void main(String [] args){
        Depot depot = new Depot();

        LinkedList<Carriage> carriages = depot.fillCarriageBase();
        LinkedList<Carriage> train1 = depot.makeTrain(carriages);
        LinkedList<Carriage> train2 = depot.makeTrain(carriages);
        LinkedList<Carriage> train3 = depot.makeTrain(carriages);

        for (Carriage carriage: train1){
            System.out.println(carriage.toString());
        }
        System.out.println("\n");
        for (Carriage carriage: train2){
            System.out.println(carriage.toString());
        }
        System.out.println("\n");
        for (Carriage carriage: train3){
            System.out.println(carriage.toString());
        }

    }
}
