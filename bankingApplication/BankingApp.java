package bankingApplication;
import java.util.Scanner;
public class BankingApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankAccount bank1 = new BankAccount("xyz","10");
		bank1.showMenu();
	}
	
	public static class BankAccount{ //Static allows the outer class "bankingapp" to not have an instance
		int balance;
		int transaction;
		String custName;
		String custID;
		
		//Constructor
		BankAccount(String cname, String cID){
			this.custName = cname;
			this.custID = cID;
		}
		
		void deposit(int amount) {
			if(amount != 0) {
				balance = balance + amount;
				transaction = amount;
			}
		}
		
		void withdraw(int amount) {
			if(amount != 0 ) {
			balance = balance - amount;
			transaction = -amount;
			}
		}
		
		void getTransaction() {
			if(transaction>0) {
				System.out.println("Depositied: " + transaction);
			}else if(transaction<0){
				System.out.println("Withdrawn: " + Math.abs(transaction));
			}
			else {
				System.out.println("No transaction has occurred");
			}
		}
		
		void showMenu() {
			Character option = null;
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Welcome " + custName);
			System.out.println("Your ID is " + custID);
			System.out.println();
			System.out.println("A. Check Balance");
			System.out.println("B. Deposit");
			System.out.println("C. Withdraw");
			System.out.println("D. Previous Transaction");
			System.out.println("E. Exit");
			
			do {
				System.out.println("==========================");
				System.out.println("Enter the Option");
				System.out.println("==========================");
				String input = sc.next().toUpperCase(); 
				option  = input.charAt(0);
				
				switch(option){
				case 'A':
					System.out.println("==========================");
					System.out.println("Balance is: " + balance);
					System.out.println("==========================");
					System.out.println("");
					break;
					
				case 'B':
					System.out.println("==========================");
					System.out.println("Enter amount to deposit");
					System.out.println("==========================");
					int amount = sc.nextInt();
					deposit(amount);
					System.out.println("");
					break;
					
				case 'C':
					System.out.println("==========================");
					System.out.println("Enter amount to withdraw");
					System.out.println("==========================");
					int amountWithdraw = sc.nextInt();
					withdraw(amountWithdraw);
					System.out.println("");
					break;
					
				case 'D':
					System.out.println("==========================");
					getTransaction();
					System.out.println("==========================");
					System.out.println("");
					break;
				case 'E':
					System.out.println("==========================");
					break;
				default:
					System.out.println("Invalid input");
					break;
				}
			}while(option!='E');	
		}
	}

}
