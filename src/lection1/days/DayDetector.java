package lection1.days;

public class DayDetector {

    public String getDay(God god){
        String day = "";
        switch (god){
            case Tutu:
                day = "Monday";
                break;
            case Lulu:
                day = "Tuesday";
                break;
            case Zuzu:
                day = "Wednesday";
                break;
            case Kuku:
                day = "Thursday";
                break;
            case Vuvu:
                day = "Friday";
                break;
            case Bubu:
                day = "Saturday";
                break;
            case Pupu:
                day = "Sunday";
                break;
            default:
                System.out.println("Expecting GOD enum at input!");
        }

        return day;
    }
}
