package lection11;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class WritePayments {

    public Payments1[] readSerialized(String path){
        if (path.isEmpty()){
            throw new IllegalArgumentException("Path is empty.");
        }
        Payments1[] payments2s = new Payments1[10];
//        Payments1 payments1;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))){
//            payments1 = (Payments1)in.readObject();
//            System.out.println(payments1.toString());
//
            Object object = in.readObject();
            int i = 0;
//            // TODO: ITERATE OVER THE WHOLE STREAM
            while (object != null && i < payments2s.length) {
                payments2s[i] = (Payments1)object;
                System.out.println(payments2s[i].toString());
                i++;
                try{
                    object = in.readObject();
                }catch (EOFException eof){
                    System.out.println("Attempt to get data at the End of File!");
                }
            }

//            payments2s = (Payments1[])in.readObject();
            for (int j = 0; j < payments2s.length; j++){
                System.out.println("count " + j);
                payments2s[j].generateCheckNumber();
                System.out.println(payments2s[j].toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return payments2s;
    }
}
