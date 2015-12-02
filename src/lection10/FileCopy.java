package lection10;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

public class FileCopy {

    public void copyFile(String existingPath, String targetPath){
        if ((existingPath == null) || (targetPath == null)){
            throw new NullPointerException("Paths could not be Null.");
        }

        if (existingPath.isEmpty() || targetPath.isEmpty()){
            throw new IllegalArgumentException("Paths could not be empty.");
        }

        Path from = Paths.get(existingPath);
        Path to = Paths.get(targetPath);

        try {
            if (Files.exists(to)){
                if(Files.isSameFile(from, to)){
                    System.out.println("It is the same file!");
                    return;
                }
            }
            if (Files.isDirectory(from)){
                System.out.println("Existing 'file' from paths is directory.");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (Files.isDirectory(to)){
                Path newFile = Paths.get(targetPath + from.getFileName());
                Files.copy(from, newFile, StandardCopyOption.REPLACE_EXISTING);

                //TODO implement in independent method
                System.out.println(newFile.getFileName());
                FileInputStream fis = new FileInputStream(String.valueOf(newFile));
                InputStreamReader isr = new InputStreamReader(fis);
                System.out.println(isr.getEncoding());
                List<String>  zzz = Files.readAllLines(newFile, Charset.forName("UTF-8"));
                Files.write(newFile, zzz, Charset.forName("CP1251"));

                File nf = new File(newFile.toUri());
                String pth = nf.getPath();
                System.out.println(pth);
                FileInputStream fs = new FileInputStream(newFile.toString());
                InputStreamReader is = new InputStreamReader(fs);
                System.out.println(is.getEncoding());

            }else {
                Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

}
