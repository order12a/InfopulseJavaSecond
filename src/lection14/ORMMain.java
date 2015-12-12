package lection14;

public class ORMMain {
    public static void main(String [] args){
        DaoDatabaseConnection daoDatabaseConnection = new DaoDatabaseConnection();
        daoDatabaseConnection.executeSelect();
    }
}
