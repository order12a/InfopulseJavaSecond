package lection10;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class test_file_nio {

	public static void main(String[] args) throws IOException {

		Path filePath = Paths.get("c:\\!!!\\test\\Test");

		// file info
		System.out.println("File information: ");
		System.out.println(" file name: " + filePath.getFileName());
		System.out.println(" root : " + filePath.getRoot());
		System.out.println(" parent : " + filePath.getParent());
		System.out.println("-----------------------");
		// path info
		System.out.println("Elements of the path: ");
		System.out.print(filePath.getRoot());
		for (Path element : filePath) {
			System.out.print("\\" + element);
		}
		System.out.println();
		System.out.println("-----------------------");

		filePath = Paths.get(".\\Test");

		System.out.println("file name : " + filePath.getFileName());
		System.out.println("URI : " + filePath.toUri());
		System.out.println("Absolute path : " + filePath.toAbsolutePath());
		System.out.println("Normalized path is: " + filePath.normalize());

		// new object from path
		Path filePath2 = Paths.get(filePath.normalize().toString());
		System.out.println("Normalized absolute path: "
				+ filePath2.toAbsolutePath());
		System.out.println("Normalized real path : "
				+ filePath2.toRealPath(LinkOption.NOFOLLOW_LINKS));
		System.out.println("-----------------------");
		// --------------------------

		// compare files - not pathes!
		filePath = Paths.get("Test");
		filePath2 = Paths
				.get("C:\\Users\\dbriskin\\workspace\\jII_file_nio\\Test");

		System.out.println("Files.isSameFile(filePath, filePath2) : "
				+ Files.isSameFile(filePath, filePath2));

		filePath2 = Paths.get("C:\\Users\\dbriskin\\workspace\\jII_file_nio");
		System.out.println(filePath2 + " is directory? "
				+ Files.isDirectory(filePath2));

		filePath = Paths.get("Test_aaaa.txt");
		System.out.println(filePath + " exist? " + Files.exists(filePath));

		filePath2 = Paths
				.get("C:\\Users\\dbriskin\\workspace\\jII_file_nio\\Test");
		System.out.println(filePath2.getFileName() + " is readable? "
				+ Files.isReadable(filePath2));

		System.out.println("-----------------------");
		// --------------------------
		Path pathSource = Paths
				.get("C:\\Users\\dbriskin\\workspace\\jII_file_nio\\Test");
		Path pathDestination = Paths
				.get("C:\\Users\\dbriskin\\workspace\\jII_file_nio\\Test.bak");
		try {
			// Files.copy(pathSource, pathDestination);
			Files.copy(pathSource, pathDestination,
					StandardCopyOption.REPLACE_EXISTING);
			// when copying catalog - files won't be copied
			Files.move(pathSource, pathDestination,
					StandardCopyOption.REPLACE_EXISTING);
			// moving catalog do move files inside
			Files.delete(pathSource);
			Files.deleteIfExists(pathSource);
			System.out.println("Source file copied successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("-----------------------");
		// --------------------------

		pathSource = Paths.get("C:\\!!!\\test");
		try {
			Files.walkFileTree(pathSource, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path path,
						BasicFileAttributes fileAttributes) {
					System.out.println("file name:" + path.getFileName());
					return FileVisitResult.CONTINUE;
					// CONTINUE: обход дерева следует продолжить.
					// TERMINATE: обход нужно прекратить.
					// SKIP_SUBTREE: подкаталоги должны быть пропущены для
					// SKIP_SIBLINGS: обход должен быть остановлен в текущем
					// каталоге и каталогах одного уровня с ним
				}

				@Override
				public FileVisitResult preVisitDirectory(Path path,
						BasicFileAttributes fileAttributes) {
					System.out.println("Directory name:" + path);
					return FileVisitResult.CONTINUE;
				}
				// FileVisitResult postVisitDirectory(T dir, IOException exc) —
				// выполняется, когда все элементы директории пройдены
				// FileVisitResult visitFileFailed(T file, IOException exc) —
				// выполняется, если к файлу нет доступа.

			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------");
		// --------------------------
		File file = new File("c:\\!!!\\test\\input.txt");
		pathSource = file.toPath();

		if (Files.exists(pathSource)) {
			try {
				// byte[] bytes = Files.readAllBytes(pathSource);
				// String text = new String(bytes, "windows-1251");
				// System.out.println(text);
				Charset charset = Charset.forName("windows-1251");
				List<String> lines = Files.readAllLines(pathSource, charset);
				System.out.println(lines);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

	}

}
