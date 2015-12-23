package lection18;

public class Params {
    private double number;
    private String taxification;
    private double connTax;

    public Params(){

    }

    public Params(double number, String taxification, double connTax) {
        this.number = number;
        this.taxification = taxification;
        this.connTax = connTax;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getTaxification() {
        return taxification;
    }

    public void setTaxification(String taxification) {
        this.taxification = taxification;
    }

    public double getConnTax() {
        return connTax;
    }

    public void setConnTax(double connTax) {
        this.connTax = connTax;
    }

    @Override
    public String toString() {
        return "Params{" +
                "number=" + number +
                ", taxification='" + taxification + '\'' +
                ", connTax=" + connTax +
                '}';
    }
}
