package lection8;

import java.util.ArrayList;
import java.util.List;

public class MainSQL {
    static String firstExercise = "SELECT * FROM classicmodels.customers where classicmodels.customers.country IN ('France','Spain')";

    public static void main(String [] args){

//        QueryManager queryManager = new QueryManager();
//        Connection connection = queryManager.setUpConnection();
//        ResultSet resultSet = queryManager.executeStatement(connection, firstExercise);
//        List<String> names = queryManager.getColumnDataString(resultSet, "customerName");
//        for (String name: names){
//            System.out.println("Customer first name is - " + name);
//        }


        QueryManagerPreparedStmt queryManagerPreparedStmt = new QueryManagerPreparedStmt();
        List<String> customerNames = new ArrayList<>(5);
        customerNames = queryManagerPreparedStmt.getColumnDataString(queryManagerPreparedStmt.executeStatement(null, "", ""),
                "customerName");
        for (String name: customerNames){
            System.out.println("Customer name - " + name);
        }
     }
}
