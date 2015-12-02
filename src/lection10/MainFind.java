package lection10;

import java.io.IOException;

public class MainFind {

    public static void main(String [] args){
        FileFinder finder = new FileFinder();
        try {
            finder.find(args[0], args[1]);
        } catch (IOException e) {
            System.out.println("Main  arguments: " + args[0] + " " +  args[1]);
            e.printStackTrace();
        }
    }
}
