package fileHandling;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class FileCopy {

	public static void main(String[] args) {
		
		copyFile(); // Calls the "copyFile" method.
	}
	
	public static void copyFile() {
		File file = new File("C:\\Users\\sadik\\Documents\\Summer\\Sample.pdf");// Creates a new File object representing the source file.
		File outFile = new File("C:\\Users\\sadik\\Documents\\Summer\\Sample-copy.pdf"); // Creates a new File object representing the destination file.

		FileInputStream fileInputStream = null; // Declares a FileInputStream variable and initialises it as null.
		FileOutputStream fileOutputStream = null;// Declares a FileOutputStream variable and initialises it as null.
		
		try {
			fileInputStream = new FileInputStream(file); // Opens the source file for reading.
			fileOutputStream = new FileOutputStream(outFile);// Opens the destination file for writing.
		} catch (FileNotFoundException e) { // Catches a FileNotFoundException if the file is not found.
			e.printStackTrace();// Prints the stack trace of the exception.
		}
		
		try {
			System.out.println(fileInputStream.available());// Prints the number of available bytes in the source file.
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		int i = 0; // Declares an integer variable.
		try {
			while((i = fileInputStream.read()) != -1) {// Reads a byte from the source file until the end of the file is reached.
				fileOutputStream.write(i);// Writes the byte to the destination file.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		finally {
			//close the stream;
			if(fileInputStream != null) {// Checks if the fileInputStream is not null.
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
