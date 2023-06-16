package StudentSystem;
import java.util.Scanner;
public class StudDelete extends StudentInfo{

	public void StudentDelete() {
		StudentInfo s1 = new StudentInfo();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the slot you want to delete");
		eraser = s.nextInt();
		eraserHeads  = eraser - 1; 
		
		if(eraser > 0 && Age[eraserHeads]!=0) {
			//each item in row slot changes 
			FName[eraserHeads] = "Empty";
			LastN[eraserHeads] = "Empty";
			Gender[eraserHeads] = "Empty";
			BDay[eraserHeads] = "Empty";
			HomeTown[eraserHeads] = "Empty";
			Teacher[eraserHeads] = "Empty";
			Section[eraserHeads] = "Empty";
			Age[eraserHeads] = 1;
			System.out.println("Student Information has been deleted");
		}else {
			System.out.println("Try again");
		}
	}

}
