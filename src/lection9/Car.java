package lection9;

public class Car {

    private String name;
    private String hullType;
    private String wheels;
    private String chairs;
    private String doors;
    private String glasses;
    private String control;
    private String painting;

    public Car(Builder builder){
        this.name = builder.name;
        this.hullType = builder.hullType;
        this.wheels = builder.wheels;
        this.chairs = builder.chairs;
        this.doors = builder.doors;
        this.glasses = builder.glasses;
        this.control = builder.control;
        this.painting = builder.painting;
    }

    public String getName() {
        return name;
    }

    public String getHullType() {
        return hullType;
    }

    public String getWheels() {
        return wheels;
    }

    public String getChairs() {
        return chairs;
    }

    public String getDoors() {
        return doors;
    }

    public String getGlasses() {
        return glasses;
    }

    public String getControl() {
        return control;
    }

    public String getPainting() {
        return painting;
    }

    @Override
    public String toString() {
        return "Car name " + getName() + " with hull '" + getHullType() + "' has " + getWheels() +
                " chairs for " + getChairs() +
                " and number of doors " + getDoors() + ". Glasses type " + getGlasses() +
                ". Has control  " + getControl() + ". Painted " + getPainting();
    }


    public static class Builder {
        public String name;
        public String hullType;
        public String wheels;
        public String chairs;
        public String doors;
        public String glasses;
        public String control;
        public String painting;

        public Mounter mounter = new Mounter(this);
        public HandWorker worker = new HandWorker(this);
        public Engineer engineer = new Engineer(this);
        public Manager manager = new Manager(this);

        public Builder(String name, String hullType) {
            if (!name.isEmpty() || !hullType.isEmpty()){
                this.name = name;
                this.hullType = hullType;
                System.out.println("Basic work has been done.");
            }else{
                throw new IllegalArgumentException("Set correct name and hull type");
            }
        }



//        public Builder setWheels(String wheels){
//              return mounter.setupWheels(this, wheels);
////            this.wheels = wheels;
////            return this;
//        }

//        public Builder setChairs(String chairs){
//            return mounter.setupChairs(this, chairs);
////            this.chairs = chairs;
////            return this;
//        }

//        public Builder setDoors(String doors){
//                return mounter.setupDoors(this, doors);
////            this.doors = doors;
////            return this;
//        }

//        public Builder setGlasses(String glasses){
//            return mounter.setupGlasses(this, glasses);
////            this.glasses = glasses;
////            return this;
//        }

//        public Builder setControl(String control){
//            return engineer.setupControl(this, control);
////            this.control = control;
////            return this;
//        }

//        public Builder setPainting(String painting){
//            return worker.paint(this, painting);
////            this.painting = painting;
////            return this;
//        }

//        public Car build(){
//            System.out.println("Checking base accomplish and release. ");
//            if(this.wheels != null || this.name !=null || this.hullType != null){
//                return new Car(this);
//            }else {
//                return null;
//            }
//        }
    }
}
