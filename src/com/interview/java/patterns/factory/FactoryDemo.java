package com.interview.java.patterns.factory;

interface Shape {
	
	void draw();
	
}


// Product concrete class

class Circle implements Shape{
	
	@Override
	public void draw() {
		System.out.println("Draw a circle");
	}
}


class Rectangle implements Shape{
	
	@Override
	public void draw() {
		System.out.println("Draw a Rectange");
	}
}



// factory interface

interface ShapeFatory{
	Shape createShape(String shapeType);
}


// Concrete factory

class SimpleFactoryImplementation implements ShapeFatory{
	
	@Override
	public Shape createShape(String shapeType) {
		if(shapeType==null)
		{
			return null;
		}
		if(shapeType.equalsIgnoreCase("Circle")) {
			return new Circle();
		}else {
			return new Rectangle();
		}
	}
}


public class FactoryDemo {
	public static void main(String[] args) {
		ShapeFatory sh= new SimpleFactoryImplementation() ;
		
		Shape shape1=sh.createShape("Circle");
		shape1.draw();
		Shape shape2=sh.createShape("Rectangle");
		shape2.draw();
		
	}
}