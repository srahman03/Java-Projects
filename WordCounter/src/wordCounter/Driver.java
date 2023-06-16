package wordCounter;
import java.util.Scanner;
public class Driver {

	public static void main(String[] args) {
//checks each word by a window of 2 but only works when there is a space before the word 
//therefore first word always needs to be counted for as there is no space in front of it.
		System.out.println("Type your paragraph:");
		Scanner scan = new Scanner(System.in);//accepts user input //points to scanner object
		String userInput = scan.nextLine(); //reads the input and returns as a string 
		scan.close();
		userInput = userInput.trim();//remove spaces beginning and end of input
		int count = 0;
		if(userInput.length() == 0) {
			count = 0;
		}else {
			//count the first word
			count++;
			for (int i=0;i<userInput.length();i++) {
				if(userInput.charAt(i) == ' '  && userInput.charAt(i+1) != ' ') {
					count++;
				}
			}
		}
		System.out.println("Word count: " + count);
	}

}
