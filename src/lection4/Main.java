package lection4;

public class Main {
    public static void main(String [] args){
        Worker worker = new Worker("Tolik");
        Detail detail = new Detail("20", 12, 15);
        Detail[] details = new Detail[200];
        for (int i = 0 ; i < 200; i++){
            details[i] = worker.copyDetail(detail);
        }

        for (int j = 1; j < details.length; j++){
            Detail copied = details[j];
            if (detail.equals(copied)){
                copied.toString();
                System.out.println("Hashcode of equal detail - " + copied.hashCode() + ", sample hashcode " + detail.hashCode());
            }else {
                System.out.println("Hashcode of non equal detail - " + copied.hashCode() + ", sample hashcode " + detail.hashCode());
            }
        }
    }
}
