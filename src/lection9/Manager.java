package lection9;

public class Manager {
    Car.Builder builder;

    public Manager(Car.Builder builder){
        this.builder = builder;
    }

    public Car build(){
        System.out.println("Checking base accomplish and release. ");
        if(this.builder.wheels != null || this.builder.name !=null || this.builder.hullType != null){
            return new Car(this.builder);
        }else {
            return null;
        }
    }
}
