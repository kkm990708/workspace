package edu.kh.test;

public class ClassDiagram {

}

public class B{
	private String f1;
	private int f2;
}

public class A{
	private B b;
}

//---------------

public class Test1{
	private Test2 t2;
	
	public Test3 method1() {
		return new Test3();
	}
	
}

public class Test2{
	private int f1;
}

public class Test3{
	private String str;
	public String getStr() {
		return str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
}

//---------------------------------------

public abstract class Parent {
	public void parentMethod1(){}
	
	protected abstract void print();
}

public class Child extends Parent{
	private String name;
	public void childMethod() {};
	
	protected void print() {}
}

//----------------------------------

public interface Resizable{
	public void resize();
}

public abstract class Shape{
	public void draw() {}
	public void erase() {}
	public int getLength() {}
	protected abstract double getArea() {}
}

public class Triangle extends Shape implements Readable{
	public boolean isEquilateral() {
		return true;
	};
	
	protected double getArea() {
		return 0;
	}
	
	public void resize() {}
}

public class Rectangle extends Shape implements Readable {
	
	public boolean isSquare() { return true;}
	protected double getArea() {
		return 0;
	}
	public void resize() {}
	
}

//-----------------------------------------------------

public class classRoom{
	private Student std;
	
	public classRoom (Student std) {
		this.std = std;
	}
}

public class Student{
	private String name;
	private int age;
}

//---------------------------------------------------

public class Book{
	private String title;
	private String author;
}

public class Library{
	private Book book;
	
	public Library() {
		this.book = new Book();
	}
}

//------------------------------------------------------

public class Product{
	private String pName;
	private int price;
}

public class Employee{
	private String name;
}

public class Shop{
	private Product product;
	private Employee emp;
	
	public Shop(Product p) {
		this.product = p;
		this.emp = new Employee();
	}
}

//-------------------------------------------------------

public abstract class Coffee{
	public String beans;
}

public class Option{
	private int shot;
	private String ice;
	private int syrup;
}

public class CafeLatte{
	private String temperature;
	private int price;
	
	public void drink() {
		Option option = new Option();
	}
}