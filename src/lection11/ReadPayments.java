package lection11;

import com.mysql.jdbc.Connection;
import lection8.QueryManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadPayments {
    static String selectQuery = "SELECT * FROM payments";

    public Payments1[] readObjects()throws SQLException{
        Payments1[] payments1 = new Payments1[10];
        QueryManager queryManager = new QueryManager();
        Connection connection = queryManager.setUpConnection();
        ResultSet resultSet = queryManager.executeStatement(connection, selectQuery);

        int i = 0;
            while (resultSet.next() && i < payments1.length){
                payments1[i] = new Payments1(resultSet.getString("customerNumber"),
                        resultSet.getString("paymentDate"),
                        Double.valueOf(resultSet.getString("amount")));
                System.out.println(payments1[i].toString());
                i++;
            }

        return payments1;
    }

    public void writeSerializedToFile(Payments1[] payments1s, String path){
        if (payments1s.length != 0){
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))){
                for (int i = 0; i < payments1s.length; i++){
                    out.writeObject(payments1s[i]);
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
