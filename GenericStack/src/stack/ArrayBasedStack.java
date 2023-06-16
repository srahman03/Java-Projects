package stack;

public class ArrayBasedStack<T> implements StackInterface<T>{
	//instance variables
	private int top;
	private T[] stack; //declared
	private int[] arr;
	
	//default constructor
	public ArrayBasedStack(){// default values for constructor to handle
		top=-1;
		stack = (T[])new Object[100];//Initialised - casted to T[] as creating T[100] doesn't work
	}
	
	//Overloaded constructor //allows user input
	public ArrayBasedStack(int size){
		top=-1; //-1 as default to make sense of an empty stack as t=0 would mean an element is in 0
		if(size>0) {
			stack = (T[])new Object[size];
		}else {
			stack = (T[])new Object[100];
		}
	}
	
	
	//non-static methods of the stack
	@Override
	public void push(T item) throws StackFullException {
		if (top < stack.length-1) {
			top++;
			stack[top] = item;
		}else {
			throw new StackFullException("Can't push on a full stack.");
		}
	}

	@Override
	public void pop() throws StackEmptyException {
		if (top >= 0) {
		stack[top] = null;
		top--;
		}else {
			throw new StackEmptyException("Can't pop on an empty stack.");
		}
	}

	@Override
	public String peek() throws StackEmptyException {
		if(top == -1) {
			throw new StackEmptyException("Cannot peek empty stack");
		}
		return stack[top].toString();
	}
	
	public void print() {
		String toReturn ="";
		int numberOfElements = top + 1;
		for(int i = 0;i<numberOfElements;i++) {
			toReturn = toReturn + stack[i].toString() + "\n";
		}
		System.out.println(toReturn);
	}
}
