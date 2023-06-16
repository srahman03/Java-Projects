package StudentSystem;

import java.util.Scanner;

public class StudAdd extends MainOption {
    public void StudentAdd() {
        StudentInfo s1 = new StudentInfo();
        Scanner s = new Scanner(System.in);

        try {
        	// Prompt the user to enter the slot they want to add
            System.out.print("\nEnter the slot you want to add: ");
            add = s.nextInt();
            System.out.println("");
            x = 1;
            adds = add - 1; // convert back to array index as slot 1 would be 0 index
        } catch (Exception error) {
            System.out.println("Invalid Input");
            StudentAdd();
        }

        try {
        	 // Check if the selected slot is not empty and the input is valid
            if (Age[adds] != 0 && add > 0) {

                do {
                	// Prompt the user to enter new student information
                    System.out.print("Enter new First Name: ");
                    slot8 = s.next();
                    System.out.print("Enter new Last Name: ");
                    slot7 = s.next();
                    System.out.print("Enter new Gender: ");
                    slot6 = s.next();
                    System.out.print("Enter new Birthday: ");
                    slot5 = s.next();
                    System.out.print("Enter new HomeTown: ");
                    slot4 = s.next();
                    System.out.print("Enter new Teacher: ");
                    slot3 = s.next();
                    System.out.print("Enter new Section: ");
                    slot2 = s.next();
                    System.out.print("Enter new Age: ");
                    slot1 = s.nextInt();
                 // Check if the entered age is valid
                    if (slot1 < 1) {
                        System.out.println("Invalid Input");
                        StudentAdd();
                    }
                    if (slot1 > 0) {
                    	// Update the student information in the corresponding arrays
                        FName[adds] = slot8;
                        LastN[adds] = slot7;
                        Gender[adds] = slot6;
                        BDay[adds] = slot5;
                        HomeTown[adds] = slot4;
                        Teacher[adds] = slot3;
                        Section[adds] = slot2;
                        Age[adds] = slot1;
                        System.out.println("Student information has been updated");
                        x++;
                    }
                } while (x < 2);

            } else {
                System.out.println("Try again");
            }
        } catch (Exception error) {
        	 // Handle exceptions and redirect to the main menu
            MainOption m = new MainOption();
            System.out.println("Invalid");
            m.main();
        }
    }
}