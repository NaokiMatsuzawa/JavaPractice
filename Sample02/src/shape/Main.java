package shape;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		shape.Shape[] shapes = new shape.Shape[2];
		shapes[0] = shape.Circle.create();
		shapes[1] = shape.Trapezoid.create();
		for(Shape shape : shapes) {
			System.out.println("This shape's area is " + shape.calcArea());
		}
	}

}
