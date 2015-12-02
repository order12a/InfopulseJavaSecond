package lection12;

public class Worker implements Comparable<Worker>{
    private String name;
    private int level;

    public Worker(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int compareTo(Worker o) {
        return this.level - o.getLevel();
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
