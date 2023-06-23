package fileHandling;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreateFile {

	public static void main(String[] args) {
		//windows: 
		String path = "C:\\Users\\sadik\\Documents\\sample.text";
		//1. using file:
		File file = new File(path);
		try {
			boolean flag = file.createNewFile();
			if(flag) {
				System.out.println("File is created");
			}else {
				System.out.println("File is already present...");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//2. FileOutputStream along Scanner:
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name with location path: ");
		String fileName = sc.nextLine();
		
		FileOutputStream fileOS = new FileOutputStream(fileName, true);
		System.out.println("Enter the file content");
		String content = sc.nextLine();
		byte b[] = content.getBytes();
		fileOS.write(b);
		fileOS.close();
		System.out.println("File is saved on the given location path");
		
		} catch (Exception e) {
			System.out.println("Some exception is coming....");
			e.printStackTrace();
		}
		System.out.println("--------------------------");
		//3. Java nio packages 
		try {
			Path pathLocation = Paths.get("C:\\Users\\sadik\\Documents\\newfile.text");
			Path newPath = Files.createFile(pathLocation);
			System.out.println("new file created at: " + newPath);
		} catch (Exception e) {
			System.out.println("Some exception is coming...");
			e.printStackTrace();
		}
		
	}
}
