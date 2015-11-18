package lection8;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryManagerPreparedStmt {
    static final String CONNECTION_NAME = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/classicmodels";
    static final String LOGIN = "order";
    static final String PASSWORD = "10109595order";

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private String sqlStatement = "SELECT customers.customerName, payments.amount as pays " +
            "FROM customers JOIN payments ON customers.customerNumber = payments.customerNumber\n" +
            "WHERE customers.country = ?";

    public Connection setUpConnection(){
        try {
            Class.forName(CONNECTION_NAME);
            connection = (Connection) DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
            System.out.println("Connection created to " + DB_URL);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ResultSet executeStatement(Connection connection, String query, String param){
        try {
            if(connection == null){
                if (query.isEmpty() || query == null){
                    preparedStatement = (PreparedStatement) setUpConnection().prepareStatement(sqlStatement);
                    if (!param.isEmpty()){
                        preparedStatement.setString(1, param);
                        resultSet = preparedStatement.executeQuery();
                    }else {
                        preparedStatement.setString(1, "France");
                        resultSet = preparedStatement.executeQuery();
                    }
                }else {
                    throw new IllegalArgumentException("Query can not be null or empty!");
                }
            }else {
                preparedStatement = (PreparedStatement) connection.prepareStatement(query);
                preparedStatement.setString(1, param);
                resultSet = preparedStatement.executeQuery();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return  resultSet;
    }

    public List<String> getColumnDataString(ResultSet resultSet, String columnName){
        List<String> columnData = new ArrayList<>(10);
        if (!(columnName.isEmpty())){
            try{
                while (resultSet.next()){
                    columnData.add(resultSet.getString(columnName));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }else {
            throw new IllegalArgumentException("Column name could not be empty!");
        }
        return  columnData;
    }
}