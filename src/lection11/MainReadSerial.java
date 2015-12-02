package lection11;

public class MainReadSerial {
    public static void main(String [] args){
        String path = "/home/order/target/read1.txt";
        WritePayments writePayments = new WritePayments();
        writePayments.readSerialized(path);
    }
}
