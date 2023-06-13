package StudentSystem;

import java.util.Scanner;

public class StudUpdate extends MainOption {
    public void StudentUpdate() {
        StudentInfo s1 = new StudentInfo();
        Scanner s = new Scanner(System.in);

        try {
            System.out.print("\nEnter the slot you want to update: ");
            edit = s.nextInt();
            System.out.println("");
            x = 1;
            edits = edit - 1; 
        } catch (Exception error) {
            System.out.println("Invalid Input");
            StudentUpdate();
        }

        try {
            if (Age[edits] != 0 && edit > 0) {

                do {

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
                    if (slot1 < 1) {
                        System.out.println("Invalid Input");
                        StudentUpdate();
                    }
                    if (slot1 > 0) {
                        FName[edits] = slot8;
                        LastN[edits] = slot7;
                        Gender[edits] = slot6;
                        BDay[edits] = slot5;
                        HomeTown[edits] = slot4;
                        Teacher[edits] = slot3;
                        Section[edits] = slot2;
                        Age[edits] = slot1;
                        System.out.println("Student information has been updated");
                        x++;
                    }
                } while (x < 2);

            } else {
                System.out.println("Try again");
            }
        } catch (Exception error) {
            MainOption m = new MainOption();
            System.out.println("Invalid");
            m.main();
        }
    }
}