package lection12;

/**
 * Created by order on 30.11.15.
 */
public class Instrument implements Comparable<Instrument> {
    private String name;
    private int difficulty;

    public Instrument(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public int compareTo(Instrument o) {
        return this.difficulty - o.getDifficulty();
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "name='" + name + '\'' +
                ", difficulty=" + difficulty +
                '}';
    }
}
