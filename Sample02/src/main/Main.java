package main;

import shape.Shape;

public class Main {

	public static void main(String[] args) {
		shape.Shape[] shapes = new shape.Shape[2];
		shape.ShapeFactory shape_factory = new shape.ShapeFactory();
		final shape.DrawMethod method_in_windows = shape.DrawMethodFactory.getInstance().getDrawMethod();
		shapes[0] = shape_factory.createCircle(method_in_windows);
		shapes[1] = shape_factory.createTrapezoid(method_in_windows);
		for(Shape shape : shapes) {
			System.out.println("This shape's area is " + shape.calcArea());
			shape.draw();
		}
	}

}
