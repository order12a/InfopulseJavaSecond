package lection16;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Depot <T>{

    /**
     * @return list of Carriage objects
     */
    public LinkedList<Carriage> fillCarriageBase(){
        LinkedList<Carriage> carriages = new LinkedList<>();
        for(int i = 0; i < 1000; i++){
            Random rnd = new Random();
            carriages.add(new Carriage("carriage_" + i, rnd.nextInt(100) < 30));
        }

        return carriages;
    }

    /**
     * @param carriages
     * @return train of carriages
     */
    public LinkedList<Carriage> makeTrain(List<Carriage> carriages){
        LinkedList<Carriage> train = new LinkedList<>();
        LinkedList<Carriage> middleCarriages = new LinkedList<>();

        LinkedList<Carriage> carriageHeadBuffer = new LinkedList<>();
        LinkedList<Carriage> carriageMiddleBuffer = new LinkedList<>();
        int c = 1;

        for (int i =0 ; i < 12; i++){
            if(carriageHeadBuffer.size() == 2 && carriageMiddleBuffer.size() == 3){
                break;
            }
            if (carriages.get(carriages.size() - c).isHead()){
                if (carriageHeadBuffer.size() < 2){
                    carriageHeadBuffer.add(carriages.get(carriages.size() - c));
                }
                carriages.remove(carriages.size() - c);
                c++;
            }
            if (!carriages.get(carriages.size() - c).isHead()){
                carriageMiddleBuffer.add(carriages.get(carriages.size() - c));
                carriages.remove(carriages.size() - c);
                c++;
            }
        }
        train.addFirst(carriageHeadBuffer.get(0));
        train.addLast(carriageHeadBuffer.get(1));

        train.add(1, carriageMiddleBuffer.get(0));
        train.add(2, carriageMiddleBuffer.get(1));
        train.add(3, carriageMiddleBuffer.get(2));
        return train;
    }
}
