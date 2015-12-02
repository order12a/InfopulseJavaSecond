package lection11;

import java.io.Serializable;
import java.util.Random;

public class Payments1 implements Serializable{
    private static final long serialVersionUID = -2583206757498021899L;
    private String customerNumber;
    private String paymentDate;
    private Double amount;
    transient private String checkNumber;

    public Payments1(String customerNumber, String paymentDate, Double amount) {
        this.customerNumber = customerNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String generateCheckNumber(){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        checkNumber = sb.toString();
        return checkNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    @Override
    public String toString() {
        return "customerNumber - " + getCustomerNumber() +
                " paymentDate - " + paymentDate +
                " amount - " + getAmount() +
                " checkNumber - " + getCheckNumber();
    }
}
