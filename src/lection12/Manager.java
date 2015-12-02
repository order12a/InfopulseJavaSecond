package lection12;

public class Manager extends Worker {
    private String label;

    public Manager(String name, int level) {
        super(name, level);
    }

    public Manager(String name, int level, String label) {
        super(name, level);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
