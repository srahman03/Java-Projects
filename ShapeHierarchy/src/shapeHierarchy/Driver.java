package shapeHierarchy;

import java.util.Scanner;


class Driver{
	public static void main (String[] args) {
		Object obj;
		int first; 
		int second;
		double r;
		double side;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter\n1:Two Dimensional shape\n2:Three Dimensional shape");
		System.out.println();
		first = input.nextInt();
		if(first == 1) {
			System.out.print("Enter number for shape:\n1:Circle\n2:Square\n3:Triangle");
			System.out.println();
			second = input.nextInt();
		}else {
			System.out.print("Enter number for shape:\n1:Sphere\n2:Cube\n3:Tetrahedron");
			System.out.println();
			second = input.nextInt();
		}
		int choice = first*10+ second;
		
		switch(choice) {
		case 11:
			System.out.print("Enter radius of circle");
			System.out.println();
			r = input.nextDouble();
			obj = new Circle(r);
			System.out.print(obj.toString());
			break;
		case 12:
			System.out.print("Enter side of square");
			System.out.println();
			side = input.nextDouble();
			obj = new Square(side);
			System.out.print(obj.toString());
			break;
		case 13:
			System.out.print("Enter side of triangle");
			System.out.println();
			double side1 = input.nextDouble();
			System.out.print("Enter side 2 of triangle");
			System.out.println();
			double side2 = input.nextDouble();
			System.out.print("Enter side3 of triangle");
			System.out.println();
			double side3 = input.nextDouble();
			obj = new Triangle(side1, side2, side3);
			System.out.print(obj.toString());
			break;
		case 21:
			System.out.print("Enter radius of sphere");
			System.out.println();
			r = input.nextDouble();
			obj = new Sphere(r);
			System.out.print(obj.toString());
			break;
		case 22:
			System.out.print("Enter side of cube");
			System.out.println();
			side = input.nextDouble();
			obj = new Cube(side);
			System.out.print(obj.toString());
			break;
		case 23:
			System.out.print("Enter side of tetrahedron");
			System.out.println();
			side = input.nextDouble();
			obj = new Tetrahedron(side);
			System.out.print(obj.toString());
			break;
		default:
			System.out.print("Invalid response");
			break;
		}
	}
}








abstract class TwoDimensionalShape{//Parent
	public double r;
	public double side;
	public double side2;
	public double side3;
	public double perimeter() {return 0.0;}//method will need overriding in class 2dShape
	public double area() {return 0.0;}//method will need overriding in class 2dShape
	public String toString() { //overrides the toString() method, which returns a string representation of the shape.
		return String.format("Area: %.2f%nPerimeter: %.2f%n", area(), perimeter());//It contains two placeholders (%.2f and %n) that will be replaced with actual values.
	}//%.2f is a placeholder for a floating-point number with two decimal places.
	//%n is a newline character, which will create a new line in the resulting string.
}

 class Circle extends TwoDimensionalShape{
	
	public Circle(double r) {this.r = r;}//constructor - initialises the r variable
	public double area() {return Math.PI*(Math.pow(r, 2));}
	public double perimeter() {return Math.PI*2*r;}
}
 
 class Square extends TwoDimensionalShape{
	 public Square(double side) //constructor
	 {this.side = side;}
	 public double area() {return Math.pow(side, 2);}
	 public double perimeter() {return side*4;}
 }
 
 class Triangle extends TwoDimensionalShape{
	 
	 public Triangle(double side1,double side2,double side3) {
		 this.side = side1;
		 this.side2 = side2;
		 this.side3 = side3;
	 }
	 public double perimeter() {return side + side2 + side3;}
	 public double area() {
		 double half = perimeter()/2;
		 double calc = Math.sqrt(half*(half-side)*(half-side2)*(half-side3));
		 return calc;
	 }
 }
 
 abstract class ThreeDimensionalShape{
	 public double side;
	 public double r;
	 public double getVolume() {return 0.0;}
	 public double getSurfaceArea() {return 0.0;}
	 public String toString() {
		 return String.format("Surface area: %.2f%nVolume: %.2f%n", getSurfaceArea(), getVolume());
	 }
 }
 
 class Sphere extends ThreeDimensionalShape{
	
	 public Sphere (double r) {this.r = r;}
	 public double getVolume() {
		 return(4/3)*Math.PI*Math.pow(r, 3);
	 }
	 public double getSurfaceArea() {
		 return 4*(Math.PI*Math.pow(r, 2));
	 }
 }
 
 class Cube extends ThreeDimensionalShape{
	 
	 public Cube(double side1) {this.side=side1;}
	 public double getVolume() {
		 return Math.pow(side, 3);
		 }
	 public double getSurfaceArea() {
		 return 6*Math.pow(side, 2);
	 }
 }
 
 class Tetrahedron extends ThreeDimensionalShape{
	 public Tetrahedron(double side2) {
		 this.side = side2;
	 }
	 public double getVolume() {
		 return (Math.pow(side, 3)/(6*Math.sqrt(2)));
	 }
	 public double getSurfaceArea() {
		 return Math.sqrt(3) * Math.pow(side, 2);
	 }
 }
 