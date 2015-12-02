package lection10;

import java.io.File;
import java.io.IOException;

public class FileFinder {

    public void find(String path, String fileName) throws IOException {

        if (path == null) {
            System.out.println("Error: Start path " + path + "  is null");
            return;
        }
        if(path.isEmpty()){
            System.out.println("Error: Start path " + path + "  is empty");
            return;
        }

        File startCatalog = new File(path);
        if (!startCatalog.exists()) {
            System.out.println("Error: Start path " + path
                    + " does not exist");
            return;
        }

        // String[] list = f.list(); // список имён файлов в текущей папке
        File[] listFiles = startCatalog.listFiles();

        if (listFiles == null) {
            System.out.println("Error: There are no files in start path");
            return;
        }

        for (File fileInCatalog : listFiles) {
            if (fileInCatalog.isDirectory()) {
                find(fileInCatalog.getAbsolutePath(), fileName); // recursive
            } else {
                if (fileInCatalog.getName().startsWith(fileName.replace("*", ""))) {
                    System.out.println(fileInCatalog.getCanonicalPath());
                }
            }
        }
    }
}
