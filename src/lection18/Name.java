package lection18;

public class Name {
    private String operatorName;
    private double payroll;
    private double smsPrice;
    private CallPrice callPrice;
    private Params params;

    public Name(String operatorName, double payroll, double smsPrice, CallPrice callPrice, Params params) {
        this.operatorName = operatorName;
        this.payroll = payroll;
        this.smsPrice = smsPrice;
        this.callPrice = callPrice;
        this.params = params;
    }

    public Name(String operatorName, double payroll, double smsPrice) {
        this.operatorName = operatorName;
        this.payroll = payroll;
        this.smsPrice = smsPrice;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public double getPayroll() {
        return payroll;
    }

    public void setPayroll(double payroll) {
        this.payroll = payroll;
    }

    public double getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(double smsPrice) {
        this.smsPrice = smsPrice;
    }

    public CallPrice getCallPrice() {
        return callPrice;
    }

    public void setCallPrice(CallPrice callPrice) {
        this.callPrice = callPrice;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Name{" +
                "operatorName='" + operatorName + '\'' +
                ", payroll=" + payroll +
                ", smsPrice=" + smsPrice +
                ", callPrice=" + callPrice.toString() +
                ", params=" + params.toString() +
                '}';
    }
}
