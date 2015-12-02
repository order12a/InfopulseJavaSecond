package lection9;

public class HandWorker {
    Car.Builder builder;

    public HandWorker(Car.Builder builder){
        this.builder = builder;
    }

    public Car.Builder paint( String painting){
        if (painting != null){
            this.builder.painting = painting;

        }else {
            throw new NullPointerException("Painting could not be null");
        }
        return builder;
    }
}
