package lection11;

import java.sql.SQLException;

public class MainSerial {
    public static void main(String [] args){
        String path = "/home/order/target/read1.txt";

        ReadPayments readPayments = new ReadPayments();
        Payments1[] payments1s = new Payments1[0];
        try {
            payments1s = readPayments.readObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("writeSerializedToFile");
        readPayments.writeSerializedToFile(payments1s, path);
    }
}
