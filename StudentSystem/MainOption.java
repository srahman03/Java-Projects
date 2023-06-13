package StudentSystem;
import java.util.Scanner;
import java.util.InputMismatchException;
public class MainOption extends StudentInfo {

	
	public void main() {
		try {
			Scanner s = new Scanner(System.in);
			StudentInfo s1 = new StudentInfo();
			System.out.println(" 1)View\n 2)Update\n 3)Delete\n 4)Add\n");
			System.out.println("Enter Your Choice: ");
			option = s.nextInt();
			
			do {
				switch (option) {
				case (1):
					System.out.println("");
					s1.StudInfo();
					this.main();
					System.out.println("=============================================================================================================================================");
					break;
					
				case (2):
					System.out.println("");
					StudUpdate u1 = new StudUpdate();
					s1.StudInfo();
					u1.StudentUpdate();
					System.out.println("=============================================================================================================================================");
					this.main();
					break;
					
				case (3):
					System.out.println("");
					StudDelete d1 = new StudDelete();
					s1.StudInfo();
					d1.StudentDelete();
					System.out.println("=============================================================================================================================================");
					this.main();
					break;
					
				case (4):
					System.out.println("");
					StudAdd a1 = new StudAdd();
					s1.StudInfo();
					a1.StudentAdd();
					System.out.println("=============================================================================================================================================");
					this.main();
					break;
					
				case (5):
					System.out.println("Invalid Input");
					this.main();
					System.out.println("Enter Your Choice");
					System.out.println("=============================================================================================================================================");
				default:
			
					}
				}while(option!=2);
			
		}catch(InputMismatchException err){
			System.out.print("Invalid Input");
		}
	
	
	}

}
