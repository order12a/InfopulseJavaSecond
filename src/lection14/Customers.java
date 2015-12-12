package lection14;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "customers")
public class Customers {
    public static final String CUSTOMER_NAME = "customerName";
    public static final String COUNTRY = "country";
    public static final String CUSTOMER_NUMBER = "customerNumber";

    @DatabaseField(id = true, canBeNull = false, useGetSet = true)
    private Integer customerNumber;

    @DatabaseField(canBeNull = false, useGetSet = true)
    private String customerName;

    @DatabaseField(canBeNull = false, useGetSet = true)
    private String country;

    Customers(){

    }

    public Customers(String customerName, String country, Integer customerNumber) {
        super();
        this.customerName = customerName;
        this.country = country;
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customerNumber=" + customerNumber +
                ", customerName='" + customerName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
