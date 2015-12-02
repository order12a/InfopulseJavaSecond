package lection9;

public class Main {

    public static void main(String [] args){
        Car car1 = new Car.Builder("BMW X5", "outlander").mounter.setupWheels("4 wheels").mounter.setupDoors("5 doors")
                .mounter.setupChairs("5 chairs").mounter.setupGlasses("5 armed glasses")
                .engineer.setupControl("mechanical wheel").worker.paint("Black color").manager.build();
        System.out.println(car1.toString());

//        Car car2 = new Car.Builder("Tesla", "sedan").setWheels("4 wheels").setDoors("4 doors").setChairs("4 chairs")
//                .setGlasses("5 polymer glasses").setControl("joystick").setPainting("white color").build();
//        System.out.println(car2.toString());
//
//        Car car3 = new Car.Builder("Renaut transporter", "bus").setWheels("4 wheels").setDoors("5 doors").setChairs("6 chairs")
//                .setGlasses("7 glasses").setControl("standard wheel").setPainting("yellow color").build();
//        System.out.println(car3.toString());
    }

}
