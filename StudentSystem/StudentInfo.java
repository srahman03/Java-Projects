package StudentSystem;
import java.util.Scanner;

public class StudentInfo {//parent class
	//arrays to store info
    public static String[] FName = {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"};
    public static String[] LastN = {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"};
    public static String[] Gender = {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"};
    public static String[] BDay = {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"};
    public static String[] HomeTown = {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"};
    public static String[] Teacher = {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"};
    public static String[] Section = {"Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty", "Empty"};
    public static int[] Age = {1, 1, 1, 1, 1, 1, 1, 1};
    
    //declaring variables 
    public static int i;
    public static int set;
    public static int edit, edits, x, adds, add;
    public static int slot1;
    String slot8, slot2, slot3, slot4, slot5, slot6, slot7;
    public static int eraser, eraserHeads;
    public static int StudentUpdate, StudentDelete, StudentAdd, option;

    public void display() {
        StudentInfo s1 = new StudentInfo();
        Scanner s = new Scanner(System.in);
        System.out.println("=============================================================================================================================================");
        System.out.println("                                                        Welcome To Student Registration                                                    ");
        System.out.println("=============================================================================================================================================");
       //creates instance and calls its main method
        MainOption m1 = new MainOption();
        m1.main();
    }

    public void StudInfo() {
        System.out.println("=============================================================================================================================================");
        System.out.println("                                                        Student Information                                                    ");
        System.out.println("=============================================================================================================================================");
       //column headers
        System.out.println("First Name\tLast Name\tGender\t\tBirthday\tHometown\tTeacher\t\tSection\t\tAge");

        for (i = 0; i < 8; i++) {
            set = i;
         // Retrieve values from arrays, replacing "Empty" with empty string if necessary
            String firstName = FName[set].equals("Empty") ? "" : FName[set];
            String lastName = LastN[set].equals("Empty") ? "" : LastN[set];
            String gender = Gender[set].equals("Empty") ? "" : Gender[set];
            String birthday = BDay[set].equals("Empty") ? "" : BDay[set];
            String hometown = HomeTown[set].equals("Empty") ? "" : HomeTown[set];
            String teacher = Teacher[set].equals("Empty") ? "" : Teacher[set];
            String section = Section[set].equals("Empty") ? "" : Section[set];
            String age = Age[set] == 1 ? "" : String.valueOf(Age[set]);
            // Print student information in a formatted line - with fixed sizing
            System.out.printf("(%d)%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\n", (i + 1), firstName, lastName, gender, birthday, hometown, teacher, section, age);
        }
    }
}
