package fileHandling;
import java.awt.Desktop;
import java.io.File;
public class OpenFileUsingDesktop {

	public static void main(String[] args) {
		String path = "C:\\Users\\sadik\\Documents\\Summer\\sample.text";
		try {
			
			File file = new File(path);
			if(Desktop.isDesktopSupported()) {
				System.out.println("Desktop not supported");
				return;
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
