package stack;

import java.util.Scanner;
public class StackDemo {
	public static void main(String[] args) {
		ArrayBasedStack<Person> personStack = new ArrayBasedStack<>();//instance of ArrayBasedStack with generic type Person and assigns it to the variable personStack
		Scanner keyboard = new Scanner(System.in);
		int option;
		do {
			System.out.println("Press 1 to push an item onto the stack");
			System.out.println("Press 2 to pop an item onto the stack");
			System.out.println("Press 3 to peek an item onto the stack");
			System.out.println("Press 4 to print the stack");
			option = keyboard.nextInt();
			keyboard.nextLine();
			
			if(option == 1) {
			
				System.out.println("Enter the name of the person");
				String name = keyboard.nextLine();
				
				System.out.println("Enter the age of the person");
				int age = keyboard.nextInt();
				Person p1 = new Person(age,name);
				
				try {
					personStack.push(p1);
				}
				catch(StackFullException e) {
					System.out.println(e.getMessage());
				}
			}
			
			else if(option == 2){
				try {
					personStack.pop();
				}
				catch(StackEmptyException e) {
					e.printStackTrace();
				}
			}
			
			else if(option == 3){
				try {
					String savedResult = personStack.peek();
					System.out.println(savedResult);
				}
				catch(StackEmptyException e) {
					System.out.println(e.getMessage());
				}
			}
			
			if(option == 4) {
				personStack.print();
			}
		}while(option!=5);
	}
}
