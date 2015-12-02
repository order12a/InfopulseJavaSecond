package lection10;

import java.io.*;

public class test_file {

	public static void main(String[] args) throws IOException {

		File file = new File("MyFile.txt");
		file.createNewFile();
		printFileDescription(file);

		file = new File("."); // current directory
		printFileDescription(file);

		file = new File(".\\MyFile.txt");
		file.createNewFile();
		printFileDescription(file);

		// ---------------------------
		file = new File("c:\\!!!\\test");
		printFileDescription(file);

		file = new File("test/.././file.txt");
		printFileDescription(file);

		findFile("c:\\!!!\\test", "Test");
		System.out.println("-----------------------------");
		// -----------------------------
		System.out.println(File.separator);
		System.out.println(File.listRoots());

		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (name.lastIndexOf('.') > 0) {
					// get last index for '.' char
					int lastIndex = name.lastIndexOf('.');
					// get extension
					String str = name.substring(lastIndex);
					// match path name extension
					if (str.equals(".txt")) {
						return true;
					}
				}
				return false;
			}
		};

		for (File fl : file.listFiles(filter)) {
			System.out.println(fl.getCanonicalPath());
		}

	}

	static void findFile(String startPath, String fileNameToFind)
			throws IOException {
		if (startPath == null) {
			System.out.println("Error: Start path " + startPath + "  is empty");
			return;
		}

		File startCatalog = new File(startPath);
		if (!startCatalog.exists()) {
			System.out.println("Error: Start path " + startPath
					+ " does not exist");
			return;
		}

		// String[] list = f.list(); // список имён файлов в текущей папке
		File[] listFiles = startCatalog.listFiles();

		if (listFiles.equals(null)) {
			System.out.println("Error: There are no files in start path");
			return;
		}

		for (File fileInCatalog : listFiles) {
			if (fileInCatalog.isDirectory()) {
				findFile(fileInCatalog.getAbsolutePath(), fileNameToFind); // recursive
			} else {
				if (fileNameToFind.equals(fileInCatalog.getName())) {
					System.out.println(fileInCatalog.getCanonicalPath());
				}
			}
		}
	}

	public static void printFileDescription(File file) throws IOException {
		System.out.println("Name           : " + file.getName());
		System.out.println("Path           : " + file.getPath());
		System.out.println("Absolute path  : " + file.getAbsolutePath());
		System.out.println("Canonical path : " + file.getCanonicalPath());
		System.out.println("Parent         : " + file.getParent());
		System.out.println("-----------------------------");
	}

	@Override
	public String toString() {
		return "test_file [";
	}
}
