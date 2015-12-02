package lection10;

public class MainCopy {

    public static void main(String [] args){
        FileCopy copy = new FileCopy();
        System.out.println("Copy arguments: "+ args[0] + " " + args[1] );
        copy.copyFile(args[0], args[1]);
    }
}
