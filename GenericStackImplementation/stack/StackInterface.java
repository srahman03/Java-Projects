package stack;

public interface StackInterface<T> {//any type of data type
	//only have method headers that have to be implemented in our class
	
	public void push(T item) throws StackFullException;//push item onto stack, exception if full
	public void pop() throws StackEmptyException;//remove item onto stack, exception if empty
	public String peek() throws StackEmptyException;//show item onto stack, exception if empty
	
}
