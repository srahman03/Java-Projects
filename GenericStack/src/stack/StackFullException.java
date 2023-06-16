package stack;

public class StackFullException extends Exception{
	//default 
	public StackFullException() {
		super(); //calls constructor of parent class
	}
	//Overloaded constructor
	public StackFullException(String message) { 
		super(message);
	}
}
