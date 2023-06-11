package stack;

public class Person {
	private String name;
	private int age;
	
	//Default constructor
	public Person() {
		this.name = "";
		this.age = 0;
	}
	//Overloaded constructor
	public Person(int age ,String name) {
		this.name = name; 
		this.age = age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return name + " " + age;
	}
}
