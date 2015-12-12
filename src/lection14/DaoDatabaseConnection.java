package lection14;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import lection12.Payments;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoDatabaseConnection {

    static ConnectionSource connectionSource;

    private static final String login = "order";
    private static final String password = "10109595order";

    static String databaseURL = "jdbc:mysql://localhost/classicmodels?" + "user=" + login + "&password=" + password;

    public void executeSelect(){
        Dao<ProductLine, String> productLinesDao;
        List<ProductLine> productLines = new ArrayList<>();
        try {
            connectionSource = new JdbcConnectionSource(databaseURL);
            productLinesDao = DaoManager.createDao(connectionSource, ProductLine.class);
            QueryBuilder<ProductLine, String> productLinesQb = productLinesDao.queryBuilder();
            productLinesQb.where().eq(ProductLine.PRODUCT_LINE_COLUMN, "Ships");
            productLines = productLinesQb.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (ProductLine productLine: productLines){
            System.out.println(productLine.toString());
        }
    }

    public void executeSelectWithJoin(){
        Dao<Payments, Integer> paymentsDao;
        Dao<Customers, Integer> customersDao;
        List<Payments> paymentAmounts = new ArrayList<>();
        try {
            connectionSource = new JdbcConnectionSource(databaseURL);

            paymentsDao = DaoManager.createDao(connectionSource, Payments.class);
            customersDao = DaoManager.createDao(connectionSource, Customers.class);

            QueryBuilder<Payments, Integer> paymentsQb = paymentsDao.queryBuilder();
            QueryBuilder<Customers, Integer> customersQb = customersDao.queryBuilder();

            //TODO finish test task
            paymentsQb.where().eq(ProductLine.PRODUCT_LINE_COLUMN, "Ships");
            paymentAmounts = paymentsQb.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (ProductLine productLine: productLines){
            System.out.println(productLine.toString());
        }
    }
}
