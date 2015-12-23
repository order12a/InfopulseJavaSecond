package lection18;

public class CallPrice {

    private double inNetwork;
    private double outNetwork;
    private double officeStations;

    public CallPrice(double inNetwork, double outNetwork, double officeStations) {
        this.inNetwork = inNetwork;
        this.outNetwork = outNetwork;
        this.officeStations = officeStations;
    }

    public double getInNetwork() {
        return inNetwork;
    }

    public void setInNetwork(double inNetwork) {
        this.inNetwork = inNetwork;
    }

    public double getOutNetwork() {
        return outNetwork;
    }

    public void setOutNetwork(double outNetwork) {
        this.outNetwork = outNetwork;
    }

    public double getOfficeStations() {
        return officeStations;
    }

    public void setOfficeStations(double officeStations) {
        this.officeStations = officeStations;
    }


    @Override
    public String toString() {
        return "CallPrice{" +
                "inNetwork=" + inNetwork +
                ", outNetwork=" + outNetwork +
                ", officeStations=" + officeStations +
                '}';
    }
}
