package lection4;

public class Detail implements Cloneable{
    private String mass;
    private int height;
    private int width;

    public Detail(String mass, int height, int width) {
        this.mass = mass;
        this.height = height;
        this.width = width;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Detail clone()throws CloneNotSupportedException{
        Detail cloned = (Detail)super.clone();
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Detail)) return false;

        Detail detail = (Detail) o;

        if (getHeight() != detail.getHeight()) return false;
        if (getWidth() != detail.getWidth()) return false;
        return getMass().equals(detail.getMass());

    }

    @Override
    public int hashCode() {
        int result = getMass().hashCode();
        result = 31 * result + getHeight();
        result = 31 * result + getWidth();
        return result;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "mass='" + mass + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
