package lection12;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "payments")
public class Payments {
    public static final String CUSTOMER_NUMBER = "customerNumber";

    @DatabaseField(id = true, canBeNull = false, useGetSet = true)
    private Integer customerNumber;

    @DatabaseField(canBeNull = false, useGetSet = true)
    private String productLine;

    public static final String AMOUNT_COLUMN = "amount";

    Payments(){
        //Default constructor
    }

    public Payments(Integer customerNumber, String productLine) {
        super();
        this.productLine = productLine;
        this.customerNumber = customerNumber;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }
}
