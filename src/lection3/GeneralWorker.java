package lection3;

import lection3.interfaces.BasicWork;
import lection3.interfaces.Occupation;

import java.util.Date;

public abstract class GeneralWorker implements BasicWork, Comparable<GeneralWorker>{
    private String name;
    private String role;
    private int salary;

    protected Occupation occupation = null;

    public GeneralWorker(String name, String role, int salary) {
        if (name != null || role != null){
            if (!name.isEmpty() || !role.isEmpty()){
                this.name = name;
                this.role = role;
            }else {
                throw new IllegalArgumentException("Name or role could not be empty.");
            }
        }else {
            throw new NullPointerException("Name or role could not be null!");
        }
        if (!(salary <= 0)){
            this.salary = salary;
        }else {
            throw new IllegalArgumentException("Set salary higher than 0");
        }

    }

    public void drink(){
        System.out.println("Each man(animal) drinks vodka.");
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()){
            this.name = name;
        }else {
            this.name = "Default" + new Date().getTime();
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if(!(salary <= 0)){
            this.salary = salary;
        }else {
            throw new IllegalArgumentException("Salary could not be 0 or lower.");
        }
    }
}
