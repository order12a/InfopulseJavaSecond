package lection9;

public class Engineer {
    Car.Builder builder;

    public Engineer(Car.Builder builder){
        this.builder = builder;
    }

    public Car.Builder setupControl(String control){

        if ((control != null) || !control.isEmpty()){
            this.builder.control = control;
        }else {
            throw new IllegalArgumentException("Control should be set up");
        }

        return builder;
    }
}
