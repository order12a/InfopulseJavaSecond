package lection16;

public class Carriage {
    private String name;
    private boolean isHead;

    public Carriage(){
        this("Head Carriage", true);
    }

    public Carriage(String name, boolean isHead) {
        this.name = name;
        this.isHead = isHead;
    }

    public boolean isHead() {
        return isHead;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "name='" + name + '\'' +
                ", isHead=" + isHead +
                '}';
    }
}
