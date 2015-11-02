package lection4;

import java.util.Random;

public class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
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
}
