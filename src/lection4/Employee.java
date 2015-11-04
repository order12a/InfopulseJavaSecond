package lection4;

/**
 * Created by order on 04.11.15.
 */
public abstract class Employee {
    private String name;

    public Employee(String name) {
        if(!name.isEmpty()){
            this.name = name;
        }else {
            throw new IllegalArgumentException("Name can not be empty!");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
