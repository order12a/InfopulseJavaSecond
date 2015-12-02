package lection9;


public class Mounter {
    Car.Builder builder;

    public Mounter(Car.Builder builder){
        this.builder = builder;
    }

    public Car.Builder setupWheels(String wheels){
        this.builder.wheels = wheels;
        return builder;
    }

    public Car.Builder setupChairs(String chairs){
        this.builder.chairs = chairs;
        return builder;
    }

    public Car.Builder setupGlasses( String glasses){
        this.builder.glasses = glasses;
        return builder;
    }

    public Car.Builder setupDoors(String doors){
        this.builder.doors = doors;
        return builder;
    }
}
